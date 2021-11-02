
package com.mycompany.tdd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    
    private final List<Producto> items = new ArrayList<>();
    private Promocion promocion;
    
    public static void main(String[] args) {
        
    }

    public void agregar(Producto producto) {
        if (producto.obtenerPrecio().compareTo(BigDecimal.ZERO) < 0 ) {
            throw new IllegalArgumentException("No se puede agregar un producto con precio negativo");
        }
        items.add(producto);
    }

    public int tamaño() {
        return items.size();
    }
    
    public BigDecimal total() {
        BigDecimal totalCarrito = new BigDecimal("0.00");
        for (Producto producto : items) {
            if (promocion != null) {
                totalCarrito = totalCarrito.add(promocion.applyTo(producto));
            }
            else {
                totalCarrito = totalCarrito.add(producto.obtenerPrecio());
            }
        }
        return totalCarrito;
    }

    public BigDecimal totalImpuesto() {
        return total().multiply(new BigDecimal("1.18"));
    }
    
    public void establecerPromocion(Promocion promocion){
        this.promocion = promocion;
    }
}
