import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestDijkstraAlgorithm {

    private List<Vertex> nodes;
    private List<Edge> edges;

    public void testExcute() {

        List<CityDistance> cities = getCities();

        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        String[] citiesAll = {"Toliatty", "Samara", "Demitrovgrad", "Ulianovsk", "Riazan", "Moscow"};

        for (int i = 0; i < citiesAll.length; i++) {
            Vertex location = new Vertex(citiesAll[i], citiesAll[i]);
            nodes.add(location);
        }

        cities = getConvertList(cities, nodes);
        for(int i = 0; i < cities.size(); i++) {
            addLane("Edge_"+i,
                    Integer.valueOf(cities.get(i).getFirstCity()),
                    Integer.valueOf(cities.get(i).getSecondCity()),
                    cities.get(i).getDistance());
        }

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(5));

        for (Vertex vertex : path) {
            System.out.println(vertex.getName());
        }

        System.out.println("Min distance: "+dijkstra.getShortDistance());
    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }

    public static List<CityDistance> getCities(){
        List<CityDistance> cities = new ArrayList<>();

        CityDistance tolSam = new CityDistance(1,"Toliatty", "Samara", 1);
        CityDistance tolDem = new CityDistance(2,"Toliatty", "Demitrovgrad", 2);
        CityDistance tolUl = new CityDistance(3,"Toliatty", "Ulianovsk", 3);
        CityDistance samRiazan = new CityDistance(4,"Samara", "Riazan", 6);
        CityDistance samUl = new CityDistance(5,"Samara", "Ulianovsk", 2);
        CityDistance demUl = new CityDistance(6,"Demitrovgrad", "Ulianovsk", 3);
        CityDistance demRiazan = new CityDistance(7,"Demitrovgrad", "Riazan", 4);
        CityDistance demMoscow = new CityDistance(8,"Demitrovgrad", "Moscow", 6);
        CityDistance ulMoscow = new CityDistance(9,"Ulianovsk", "Moscow", 5);
        CityDistance riazanMoscow = new CityDistance(10,"Riazan", "Moscow", 2);
        CityDistance riazanUl = new CityDistance(11, "Riazan", "Ulianovsk", 3);

        cities.add(tolSam);
        cities.add(tolDem);
        cities.add(tolUl);
        cities.add(samRiazan);
        cities.add(samUl);
        cities.add(demUl);
        cities.add(demRiazan);
        cities.add(demMoscow);
        cities.add(ulMoscow);
        cities.add(riazanMoscow);
        cities.add(riazanUl);

        return cities;
    }

    public static List<CityDistance> getConvertList(List<CityDistance> cities, List<Vertex> nodes){
        for(int i = 0; i < nodes.size(); i++) {
            for(int j = 0; j < cities.size(); j++) {
                if(cities.get(j).getFirstCity() == nodes.get(i).getName()){
                    cities.get(j).setFirstCity(String.valueOf(i));
                }
                if(cities.get(j).getSecondCity() == nodes.get(i).getName()){
                    cities.get(j).setSecondCity(String.valueOf(i));
                }
            }
        }
        return cities;
    }
}


