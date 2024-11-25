package br.com.tfurtado.shopping.adapters;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private double grade;

    public ProductModel(String name, String description, double price, String imageUrl, double grade) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getGrade() {
        return grade;
    }

    public static List<ProductModel> getInstances() {
        ArrayList<ProductModel> products = new ArrayList<>();
        products.add(new ProductModel("Monitor AOC 144hz 24'", "Monitor Gamer HERO 23,8'' 144Hz IPS FreeSync 24G2/BK Cor Preto/Vermelho AOC 100V/240V", 1400, "https://http2.mlstatic.com/D_NQ_NP_935086-MLU72748263335_112023-O.webp", 4.5));
        products.add(new ProductModel("Macbook pro m4", "Macbook Pro 14'' M4, 10cpu 10gpu 16gb Ram 512gb Ssd", 17599, "https://www.apple.com/newsroom/images/2024/10/new-macbook-pro/article/Apple-MacBook-Pro-M4-lineup_big.jpg.large.jpg", 4.8));
        products.add(new ProductModel("Iphone 14 Pro Max", "Apple iPhone 15 Pro Max (512 GB) — Titânio natural", 5999, "https://cdn.awsli.com.br/2601/2601098/produto/232955476/iphone-14-pro-max-128gb-5g-dourado-mq9r3be-a-1-4b56faq9hp.jpg", 4.9));
        products.add(new ProductModel("Galaxy S22 Ultra", "Samsung Galaxy S23 Ultra 5G 512GB Tela 6.8'' 12GB RAM IP68 Processador Qualcomm Snapdragon 8 Gen 2 Câmera Quádrupla de até 200MP + Selfie 12MP - Preto", 5250, "https://i.zst.com.br/thumbs/12/e/15/-796874369.jpg", 4.7));
        products.add(new ProductModel("Notebook Gamer", "Notebook Acer Nitro V15 ANV15-51-58AZ 13ª Geração Intel Core i5-13420H, 8GB RAM, 512GB SSD, NVIDIA RTX 3050, 15.6\" FHD LED IPS 144Hz, Windows 11, Preto, Retroiluminado", 7657, "https://i.zst.com.br/thumbs/12/4/29/-869180987.jpg", 4.6));

        return products;
    }
}
