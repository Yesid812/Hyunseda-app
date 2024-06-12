package co.hyunseda.product.Presentation.rest;


import co.hyunseda.product.domain.entity.Product;
import co.hyunseda.product.domain.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@Api(value="Microservicios de productos", description="Crud de productos")

public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * Listar todos los productos
     * @return Lista de todos los productos
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> findAll() {
        return productService.findAll();
    }

    /**
     * Listar productos por categorías
     * @param categoryName Nombre de la categoría a buscar
     * @return Lista de los productos por categoría
     */
    @GetMapping(value = "/products-by-categories/{categoryName}",produces = "application/json")
    public List<Product> findProductByCategory(@PathVariable String categoryName) {
        return productService.searchProductByCategory(categoryName);
    }

    /**
     * Agregar un nuevo producto
     * @param product Producto a agregar
     * @return Boleano true en caso de ser agregado correctamente y false en caso contrario
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public boolean create(@RequestBody Product product) {
        return productService.save(product);
    }


    /**
     * Buscar un producto por id
     * @param id Identificador del producto a buscar
     * @return Producto encontrado o error en caso contrario
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @ApiOperation(value="Busca un producto por id")
    public Product findById(@ApiParam(value="Identificador del producto") @PathVariable Long id)  {

        Product product = productService.findById(id);
        return product;
    }


    /**
     * Actualizar un producto
     * @param product Informacion del producto actualizada
     * @param id Identificador del producto a actualizar
     * @return Boleano true en caso de ser actualizado correctamente y false en caso contrario
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public boolean edit(@RequestBody Product product, @PathVariable Long id){
        return productService.edit(id, product);
    }


    /**
     * Eliminar un producto
     * @param id Identificador del producto a eliminar
     * @return Boleano true en caso de ser eliminado y false en caso contrario
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Long id)  {
        return productService.delete(id);
    }
}
