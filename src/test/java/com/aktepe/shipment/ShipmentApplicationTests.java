package com.aktepe.shipment;

import com.aktepe.shipment.controller.ShippingController;
import com.aktepe.shipment.entity.Product;
import com.aktepe.shipment.entity.Sale;
import com.aktepe.shipment.entity.ShippingControl;
import com.aktepe.shipment.error.MyNotFoundError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThatObject;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ShipmentApplicationTests {
	private int saleId = 3;
	private int productId = 15;

	@Autowired
	private ShippingController shippingController;

	@Test
    void shippingControlAllLayers() {
		Sale sale = new Sale(saleId, "0c784421-3cbb-4566-ab72-06628413758b", productId);
		Product product = new Product(productId, "Beauty", "Generic Concrete Ball", "113.00", "https://s3.amazonaws.com/uifaces/faces/twitter/petar_prog/128.jpg");
		ShippingControl expectedShippingControl = new ShippingControl(false, sale, product);
		ShippingControl actualShippingControl = shippingController.getShippingInfo(saleId);

        assertThat(actualShippingControl.getStatus()).isEqualTo(expectedShippingControl.getStatus());
		assertThatObject(actualShippingControl.getSale()).isEqualToComparingFieldByField(expectedShippingControl.getSale());
		assertThat(actualShippingControl.getProduct()).isEqualToComparingFieldByField(expectedShippingControl.getProduct());
    }

	@Test
	void shippingControlAllLayersBadSaleId() {
		Exception exception = Assertions.assertThrows(MyNotFoundError.class, () -> shippingController.getShippingInfo(90));
		Assertions.assertEquals("There is no sale with this saleId!", exception.getMessage());
	}

	@Test
	void shippingControlAllLayersBadProductId() {
		Exception exception = Assertions.assertThrows(MyNotFoundError.class, () -> shippingController.getShippingInfo(4));
		Assertions.assertEquals("There is no product with this productId relevant to this sale!", exception.getMessage());
	}

//	@Test
//	void shippingControlAllLayersNoShippingwithSaleId() {
//		Exception exception = Assertions.assertThrows(MyNotFoundError.class, () -> shippingController.getShippingInfo(saleId));
//		Assertions.assertEquals("There is no shipping with this saleId!", exception.getMessage());
//	}
}
