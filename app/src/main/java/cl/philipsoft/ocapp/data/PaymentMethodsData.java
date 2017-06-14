package cl.philipsoft.ocapp.data;

import java.util.List;

import cl.philipsoft.ocapp.models.PaymentMethod;

/**
 * Created by phil_ on 13-06-2017.
 */

public class PaymentMethodsData {
    public List<PaymentMethod> paymentMethods() {
        return PaymentMethod.listAll(PaymentMethod.class);
    }

    public void handler(PaymentMethod[] paymentMethods) {
        for (PaymentMethod paymentMethod :
                paymentMethods) {
            List<PaymentMethod> paymentMethodList = PaymentMethod.find(PaymentMethod.class, "id = ?", String.valueOf(paymentMethod.getId()));
            if (paymentMethodList == null || paymentMethodList.size() == 0) {
                paymentMethod.save();
            }
        }
    }
}
