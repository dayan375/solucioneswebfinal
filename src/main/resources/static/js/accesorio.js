(function(){



    var listaBotonesEditar = document.querySelectorAll(".editarProducto");

    listaBotonesEditar.forEach(item =>{

        item.addEventListener("click", e =>{

            document.getElementById('id').value = item.dataset.id;

            document.getElementById('cboCategoria').value = item.dataset.categoria;

            document.getElementById('txtNombre').value = item.dataset.nombre;

            document.getElementById('txtPrecio').value = item.dataset.precio;

            document.getElementById('txtStock').value = item.dataset.stock;

            new bootstrap.Modal(document.getElementById('modalEditar')).show();

        });

    });



})();