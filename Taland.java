/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taland;

import Entity.Event;
import Entity.Like;
import Entity.user;
import Entity.Post;
import Services.ServiceComment;
import Services.ServiceEvent;
import Services.ServiceLike;
import Services.ServiceUsers;
import Services.ServicePost;
import java.sql.*;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Entity.Category;
import Entity.Magasin;
import Entity.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Services.ServiceBasket;
import Services.ServiceMagasin;
import Services.ServiceProduct;
import Services.ServiceUser;

//import java.sql.Date;
import java.util.List;
import static javafx.application.Application.launch;

/**
 *
 * @author Amine
 */
public class Taland extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
        stage.setFullScreen(true);

    }

    public void test() {
//        user u1 = new user(31, "amine", "amine.mbarki", "amine123", "admin", "amine", "mbarki", "12/12/2012", "", "homme", "bio", 0, "not connected");
//
//        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
//        date.setDate(20);
//        date.setMonth(0);//starts from 0=january
//        date.setYear(120); //starts from 1900     
//
//        Event e1 = new Event(5, "3 Mètres Au Dessus De lART", "Seul incompris et fatigué Voulant à tout prix m’évader", "ESB Ghazela", date, 30, 0, 100, u1.getId());
//        Event e2 = new Event(4, "3 Mètres Au Dessus De lART", "Seul incompris et fatigué Voulant à tout prix m’évader", "Charguia", date, 50, 0, 100, u1.getId());
//
//        Post p4 = new Post(18, 9, "5 months later and i still don’t know the dance", "photo", 0, 0);
//        Post p3 = new Post(19, 11, "CEO of doing this pose since middle school", "photo", 0, 0);
//        Post p2 = new Post(20, 11, "My rose garden dreams, set on fire by fiends", "photo", 0, 0);
//        Post p1 = new Post(21, 11, "thinkin the same thing. To each their own though I suppose.", "photo", 0, 0);
//        Post p5 = new Post(22, 10, "what a nice day.", "", 0, 0);
//
//        Magasin m = new Magasin(10, 1, 1, "magasin generale", "MG", "79486514681");
//        Magasin m1 = new Magasin(10, 2, 1, "houni", "MG", "79486514681");
//        Magasin m2 = new Magasin(10, 1, 2, "carfour", "MG", "79486514681");
//        Magasin m3 = new Magasin(10, 2, 2, "midoun", "MG", "79486514681");
//        Magasin m4 = new Magasin(25, 1, 4, "oppo", "MG", "79486514681");
//
//        Date actuelle = new Date();
//        java.sql.Date dateFormat = new java.sql.Date(new java.util.Date().getTime());
//
//        Product p = new Product(17, "piano", 1, 500.0f, 1, (java.sql.Date) dateFormat);
//
//        Services.ServiceEvent SE = new ServiceEvent();
//        Services.ServiceUser SU = new ServiceUser();
//        ServiceProduct SP = new ServiceProduct();
//        ServiceMagasin SM = new ServiceMagasin();
//
//        List<Magasin> lm = new ArrayList<>();
//        List<Product> lp = new ArrayList<>();
//
//      //  SE.addEvent(e1);
//        //SE.deleteEvent(e1);
//        //SE.updateEvent(e2, u1.getId()); //seul l'utilisateur qui a posté l'event peut modifier
//        //SE.SearchEvents("incompris");
//  //      SE.TrierEvents(2).stream().forEach(System.out::println);
//        //SE.getEvents().stream().forEach(System.out::println);
//        Services.ServiceComment SC = new ServiceComment();
//        Services.ServicePost SPo = new ServicePost();
//        Services.ServiceLike SL = new ServiceLike();
//
//        SPo.addPost(p5);
//
//        System.out.println("******** ALL Posts *********");
//        SPo.getPosts().stream().forEach(System.out::println);
//
//        System.out.println("********Post : " + p5.getDescription() + " *********");
//        System.out.println(SPo.getById(p5.getIdPost()));
//
//        System.out.println("********* LIKES **********");
//
//        SL.addLike(p4, u1);
//        SL.addLike(p4, u1);
//
//        //SL.deletePostLike(p4, u1);
//        System.out.println("********Post : " + SPo.getById(p4.getIdPost()) + " ******");
//
//        SL.TrierPostLikesByDate(p4);
//
//        System.out.println("********* comments **********");
//
//        //SC.addComment(p4, u1, "woooow");
//        //SC.addComment(p4, u1, "Vraiment haja lixe");
//        System.out.println(SU.getById(u1.getId()));
//
//        SC.displayPostComments(p4);
//
//        /**
//         * ****************************Hamza*******************
//         */
////        Category c = new Category(1, "music");
////        System.out.println("*****************************add product");
////        SP.addProduct(p);
////        lp = SP.getProducts();
////        System.out.println("*****************************tous les produits");
////        lp.stream().forEach(System.out::println);
////      System.out.println("*****************************update price");
////        SP.updatePrice(p, 152.0f);
////        System.out.println("*****************************products by price range");
////        lp = SP.getProductsByPriceRange(0, 15);
////        lp.stream().forEach(System.out::println);
////        System.out.println("*****************************tri par prix croissant");
////        lp = SP.getProductsSortedByPriceIncreasing();
////        lp.stream().forEach(System.out::println);
////        System.out.println("*****************************tri alphabetique");
////        lp = SP.getProductsSortedByNameReversed();
////        lp.stream().forEach(System.out::println);
////        System.out.println("*****************************total de panier");
////        ServiceBasket SB = new ServiceBasket();
////        double t = SB.getTotal();
////        System.out.println(t);
////        System.out.println(SB.getMyBasket());
////        SP.addProduct(p);
////        SP.deleteProduct(p);        
//        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

/**
 * ************* TOUTA *********
 */
        //java.util.Date date=new java.util.Date();       
        //date=SE.parseDate("2020-01-24 8:0:0");
