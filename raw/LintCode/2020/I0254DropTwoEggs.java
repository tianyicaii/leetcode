package lintcode;

import java.util.ArrayList;

public class I0254DropTwoEggs {
    
    public int dropEggs(int n) {

        ArrayList<Long> dp = new ArrayList<>();

        dp.add(0L);
        dp.add(1L);

        while (dp.get(dp.size() - 1) < n) {
            dp.add(dp.get(dp.size() - 1) + dp.size());
        }

        return dp.size() - 1;
    }
}
