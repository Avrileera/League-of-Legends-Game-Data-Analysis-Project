package bean;

import java.util.*;

public class WinRateAnalyzeBean {
    public int winGame;
    public int totalGame;
    public HashMap<String, Integer> winPlayer = new HashMap();
    public HashMap<String, Integer> losePlayer = new HashMap();

    public String toString() {
        return "game:("+winGame+","+totalGame+") "+winPlayer.size()+" "+losePlayer.size();
    }

    public String getTop5() {

        HashMap<String, Float> newMap = new HashMap();
        for(String k: winPlayer.keySet()) {
            int win = winPlayer.get(k);
            int lose = 0;
            if(losePlayer.containsKey(k)) lose = losePlayer.get(k);
            newMap.put(k, 100.0f*win/(win+lose));
        }

        for(String k: losePlayer.keySet()) {
            int lose = losePlayer.get(k);
            int win = 0;
            if(winPlayer.containsKey(k)) win = winPlayer.get(k);
            newMap.put(k, 100.0f*win/(win+lose));
        }

        ArrayList<Map.Entry<String, Float>> list = new ArrayList(newMap.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,Float>>() {
            public int compare(Map.Entry<String, Float> o1,
                               Map.Entry<String, Float> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        String lowest5 = "";
        String highest5 = "";

        for(int i=0; i<(list.size()>5?5:list.size()); i++) {
            lowest5 += (list.get(i).getKey() + "-" + String.format("%.2f", list.get(i).getValue())+"% ");
        }
        for(int i=list.size()-1; i>=(list.size()>5?list.size()-5:0); i--) {
            highest5 += (list.get(i).getKey() + "-" + String.format("%.2f", list.get(i).getValue())+"% ");
        }

        return " [Highest Top 5 against Champion: "+highest5+"] [Lowest Top 5 against Champion: "+lowest5+"]";
    }

}
