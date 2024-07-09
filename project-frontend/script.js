
function convertToNumber(priceFormat){
    return priceFormat.replace(/\./g, '').replace(',', '.');
}

var products = [
    {
        id: 1,
        name: "ASUS ROG Strix Scar 18",
        description: "Intel Core i9-14900K",
        price: 35000,
        category: 2,
        promotion: true,
        new: true
    },
    {
        id: 2,
        name: "Acer Nitro 5 AN515-58-54UH",
        description: "Intel Core i5-14600KF",
        price: 15000,
        category: 3,
        promotion: false,
        new: true
    },
    {
        id: 3,
        name: "Acer Nitro 5 AN515-58-54UH",
        description: "Intel Core i5-13400",
        price: 30000,
        category: 1,
        promotion: false,
        new: false
    }
]

var categorias = [
    { id: 1, name: "produção própria" },
    { id: 2, name: "Nacional" },
    { id: 3, name: "Importado" }

]


loadProducts()

function save(){
    var prod = {
        id: products.length + 1,
        name: document.getElementById("inputName").value,
        description: document.getElementById("inputDescription").value,
        price: convertToNumber(document.getElementById("inputPrice").value),
        category: document.getElementById("selectCategory").value,
        promotion: document.getElementById("checkBoxPromotion").checked,
        new: document.getElementById("CheckBoxNewProduct").checked
    }

    addNewRow(prod)
    products.push(prod)
    document.getElementById("formProduct").reset()
}

function loadProducts() {

    for (let prod of products) {
        addNewRow(prod)
    }

}

function addNewRow(prod) {



var formatter = new Intl.NumberFormat("pt-br",{
    style: "currency",
    currency: "BRL"
})

    var table = document.getElementById("productsTable");

    var newRow = table.insertRow()

    
    

    var idNode = document.createTextNode(prod.id);

    var cell = newRow.insertCell()

    
    
    cell.appendChild(idNode);
    

    
    var cell = newRow.insertCell()
    
    cell.innerHTML = prod.name;


    cell = newRow.insertCell()
    cell.className = "d-none d-md-table-cell"
    
    
    cell.innerHTML = prod.description;
    
    cell = newRow.insertCell()
    
    cell.innerHTML = formatter.format(prod.price);
    for (let cat of categorias) {
        if (cat.id == prod.category) {
            cell = newRow.insertCell()
            cell.innerHTML = cat.name
        }

    }

    cell = newRow.insertCell()
    cell.className = "d-none d-md-table-cell"
    cell.innerHTML = `<span class="badge text-bg-success">${prod.promotion ? 'P' : ''}</span> <span class="badge text-bg-primary">${prod.new ? 'L' : ''}</span>`
    
    
    
    
}

/*
 <tr>
                        <th scope="row">1</th>
                        <td>ASUS ROG Strix Scar 18</td>
                        <td>Intel Core i9-14900K</td>
                        <td>R$ 35.000,00</td>
                        <td>Nacional</td>
                        <td>
                            <span class="badge text-bg-success">P</span>
                            <span class="badge text-bg-primary">L</span>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">2</th>
                        <td>Acer Nitro 5 AN515-58-54UH</td>
                        <td>Intel Core i5-14600KF</td>
                        <td>R$ 15.000,00</td>
                        <td>Importado</td>
                        <td> <span class="badge text-bg-primary">L</span></td>
                      </tr>
                      <tr>
                        <th scope="row">3</th>
                        <td>Lenovo Legion 7i</td>
                        <td>Intel Core i5-13400</td>
                        <td>R$ 30.000,00</td>
                        <td>Produção Própria</td>
                        <td></td>
                      </tr>





*/