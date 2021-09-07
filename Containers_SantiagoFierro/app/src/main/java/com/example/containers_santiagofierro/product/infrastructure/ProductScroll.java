package com.example.containers_santiagofierro.product.infrastructure;

import android.widget.TextView;

import com.example.containers_santiagofierro.product.domain.Product;

public final class ProductScroll {

    public static void fill(TextView[] txtProducts, Product[] products) {
        for (int i = 0; i < txtProducts.length; i++) {
            txtProducts[i].setText( products[i].showWithPrice() );
        }
    }
}
