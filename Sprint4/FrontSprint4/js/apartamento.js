const url = "http://localhost:8080/apartamento/"
const url1 = "http://localhost:8080/apartamento/list"

const contenedor = document.querySelector('tbody')

let resultados = ''

const modalClientes = new bootstrap.Modal(document.getElementById('modalApartamento'))
const formClientes = document.querySelector('form') 
const idApto = document.getElementById('id')
const nombreapto = document.getElementById('nombre_apto')
const nombre = document.getElementById('nombre')

let opcion = ''

btnCrear.addEventListener('click', () => {
    idApto.value = ''
    nombreapto.value = ''
    nombre.value = ''  
    idApto.disabled = false
    modalClientes.show()
    opcion = 'crear'
})
/*
btnCerrar.addEventListener('click', () => {

    modalClientes.hide()
    
})*/

const mostrar = (Apartamentos) => {
    Apartamentos.forEach(Apartamento => {
        resultados += `<tr> 
        <td >${Apartamento.apartamento_id}</td> 
        <td >${Apartamento.apartamento_name}</td> 
        <td >${Apartamento.apartamento}</td> 
        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td> 
        </tr>`
    })
    contenedor.innerHTML = resultados
}

fetch(url1)
    .then(response => response.json())
    .then(data => mostrar(data))
    .catch(error => console.log(error))
const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector))
            handler(e)
    })

} 

on(document, 'click', '.btnBorrar', e => {
    const fila = e.target.parentNode.parentNode
    const id = fila.firstElementChild.innerHTML
    console.log(id)
    alertify.confirm("Desea eliminar el Apto "+id,
        function () {
            fetch(url + id, {
                method: 'DELETE'
            })
                .then(() => location.reload())
        },
        function () {
            alertify.error('Cancel')
        });
})
let idForm = 0
on(document, 'click', '.btnEditar', e => {

    const fila = e.target.parentNode.parentNode
    
    idForm = fila.children[0].innerHTML
    const nombre_apto = fila.children[1].innerHTML
    const nombre_dueño = fila.children[2].innerHTML
    idApto.value = idForm
    idApto.disabled = true
    nombreapto.value = nombre_apto
    nombre.value = nombre_dueño
    
    opcion = 'editar'
    modalClientes.show()
})

formClientes.addEventListener('submit', (e) => {
    e.preventDefault()

        if (opcion == 'crear') {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    apartamento_id: idApto.value,
                    apartamento_name: nombreapto.value,
                    apartamento: nombre.value
                })
            })
                .then(response => response.json())
                .then(data => {
                    const nuevoApto = []
                    nuevoApto.push(data)
                    mostrar(nuevoApto)
                })
        }
        if (opcion == 'editar') {

            fetch(url, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    apartamento_id: idApto.value,
                    apartamento_name: nombreapto.value,
                    apartamento: nombre.value
                })
            })
                .then(response => location.reload())

        }
        modalClientes.hide()
    
})

