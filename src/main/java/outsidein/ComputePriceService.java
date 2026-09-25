package outsidein;

import java.util.List;

public class ComputePriceService {
    public Integer totalPrice(List<ItemRequest> itemRequests, boolean isFidele) {
        Panier panier = new Panier(itemRequests.stream().map(request -> new Item(request.name(), request.price())).toList());
        return panier.totalPrice(isFidele);
    }
}
