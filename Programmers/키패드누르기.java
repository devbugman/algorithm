public class 키패드누르기 {


    class HandPoint{
        int col,row;
        HandPoint(int row, int col){
            this.row = row;
            this.col = col;
        }

        public String getHand(String hand) {
            String finger = "right".equals(hand) ? "R" : "L";
    
            if (this.col == 2)
                finger = "R";
            else if (this.col == 0)
                finger = "L";
            else {
                int rightHand = Math.abs(this.row - right.row) + Math.abs(this.col - right.col);
                int leftHand = Math.abs(this.row - left.row) + Math.abs(this.col - left.col);

                if(rightHand > leftHand){
                    finger = "L";
                }else if(rightHand < leftHand){
                    finger = "R";
                }
                
            }
            return finger;
        }
    }

    HandPoint current;
    HandPoint right;
    HandPoint left;

    /**
     * @param numbers 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
     * @param hand    right
     * @return LRLLLRLLRRL
     */
    public String solution(int[] numbers, String hand) {
        left = new HandPoint(3, 0);
        right = new HandPoint(3, 2);
        String answer = "";
        for (int num : numbers) {
            current = new HandPoint((num - 1) / 3,(num - 1) % 3);
            
            
            if(num == 0){
                current = new HandPoint(3, 1);
            }
            String finger = current.getHand(hand);
            if(finger.equals("L")){
                left = current;
            }else{
                right = current;
            }

            answer += finger;
        }
        return answer;
    }



    public static void main(String[] arg) {
        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        String hand = "right";
        키패드누르기 s = new 키패드누르기();
        System.out.println(s.solution(numbers, hand));
    }
}
