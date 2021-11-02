
package com.mycompany.tdd;

import java.math.BigDecimal;

public class Producto {
    
    private BigDecimal precio;
    
    public Producto(BigDecimal precio) {
        this.precio = precio;
    }
    
    public BigDecimal obtenerPrecio() {
        return precio;
    }
}
