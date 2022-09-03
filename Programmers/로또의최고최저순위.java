class 로또의최고최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) { 
        int zero = 0; 
        int minWin = 0;
        
        for(int i = 0; i < lottos.length; i++ ) {
            
            if(lottos[i] == 0) {
                zero++;
            }
            for(int j = 0; j < lottos.length; j++) {
                    if(win_nums[j] == lottos[i]) {
                        minWin++;        
                    }   
                }
        }
        return new int[]{Math.min(7-(zero + minWin), 6), Math.min(7 - minWin, 6)};
    }
}