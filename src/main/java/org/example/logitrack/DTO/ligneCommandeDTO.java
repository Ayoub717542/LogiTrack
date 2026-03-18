package org.example.logitrack.DTO;

public class ligneCommandeDTO {
        public Integer productId;
        public int quantite;

    public ligneCommandeDTO(Integer productId, int quantite) {
        this.productId = productId;
        this.quantite = quantite;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
