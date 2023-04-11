const url = "http://localhost:8080/payment/"
const url1 = "http://localhost:8080/payment/list"
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalFacturas = new bootstrap.Modal(document.getElementById('modalFactura'))
const formFacturas = document.querySelector('form')

const payment_id = document.getElementById('payment_id')
const payment_reference = document.getElementById('payment_reference')
const payment_person_name = document.getElementById('payment_person_name')
const payment_person_email = document.getElementById('payment_person_email')
const payment_status = document.getElementById('payment_status')
const created_at = document.getElementById('created_at')
const apartamento = document.getElementById('apartamento')

let opcion = ''

btnCrear.addEventListener('click', () => {
    payment_id.value = ''
    payment_reference.value = ''
    payment_person_name.value = ''
    payment_person_email.value = ''
    payment_status.value = ''
    created_at.value = ''
    apartamento.value = ''

    payment_id.disabled = false
    modalFacturas.show()
    opcion = 'crear'
})

btnCerrar.addEventListener('click', () => {

    modalFacturas.hide()

})

const mostrar = (Facturas) => {
    Facturas.forEach(Factura => {
        resultados += `<tr>
                        <td >${Factura.payment_id}</td>
                        <td >${Factura.payment_reference}</td>
                        <td >${Factura.payment_person_name}</td>
                        <td >${Factura.payment_person_email}</td>
                        <td >${Factura.payment_status}</td>
                        <td >${Factura.created_at}</td>
                        <td >${Factura.apartamento.apartamento_name}</td>
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

    alertify.confirm("Desea eliminar la Factura " + id,
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



on(document, 'click', '.btnEditar', e => {
    const fila = e.target.parentNode.parentNode
    
    idForm = fila.children[0].innerHTML
    const referencia = fila.children[1].innerHTML
    const personName = fila.children[2].innerHTML
    const personMail = fila.children[3].innerHTML
    const status = fila.children[4].innerHTML
    const created_at = fila.children[5].innerHTML
    const idapartamento = fila.children[6].innerHTML
    payment_id.value = idForm
    payment_id.disabled = true
    payment_reference.value = referencia
    payment_person_name.value = personName
    payment_person_email.value = personMail
    payment_status.value = status
    created_at.value = created_at
    apartamento.value = idapartamento

    opcion = 'editar'
    modalFacturas.show()
})


formFacturas.addEventListener('submit', (e) => {
    e.preventDefault()

    if (opcion == 'crear') {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                payment_id: payment_id.value,
                payment_reference: payment_reference.value,
                payment_person_name: payment_person_name.value,
                payment_person_email: payment_person_email.value,
                payment_status: payment_status.value,
                created_at: created_at.value,
                apartamento: { apartamento_id: apartamento.value, apartamento_name: null, apartamento: null }
            })
        })
            .then(response => response.json())
            .then(data => {
                const nuevaFactura = []
                nuevaFactura.push(data)
                mostrar(nuevaFactura)
            })
    }
    if (opcion == 'editar') {

        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                payment_id: payment_id.value,
                payment_reference: payment_reference.value,
                payment_person_name: payment_person_name.value,
                payment_person_email: payment_person_email.value,
                payment_status: payment_status.value,
                created_at: created_at.value,
                apartamento: { apartamento_id: 6, apartamento_name: null, apartamento: null }
             })
        })
            .then(response => location.reload())

    }
    modalFacturas.hide()

})






