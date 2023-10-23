class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        return Math.min(distanceBetweenBusStopsCircular(distance, start, destination), distanceBetweenBusStopsCircular(distance, destination, start));
    }

    private int distanceBetweenBusStopsCircular(int[] distance, int start, int destination){
        int summedDistance = 0, n = distance.length;
        for(int i = start; i != destination; i = (i + 1)%n){
            summedDistance += distance[i];
        }
        return summedDistance;
    }
}