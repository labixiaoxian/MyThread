package threadcoreknowledge;

/**
 * Created by XiaoXian on 2020/10/12.
 */
public class Triangle {

        public static void main(String[] args) {
            Triangle triangle = new Triangle();
            String resultString = triangle.makeTriangle(1, 2, 3);
            System.out.println(resultString);
            System.out.println("===========================");
        }

        /**
         * 传入三个整数，返回三角形类型：不等边，等腰，等边，非三角形
         * @param a
         * @param b
         * @param c
         * @return
         */
        public String makeTriangle(Integer a,Integer b,Integer c) {
            String result = null;
            if (checkNumber(a,b,c)) {//判断数据合法性
                if (checkTriangle(a,b,c)) {//判断是否构成三角形
                    //判断三角形类型
                    //1.等边
                    if (a == b && a==c && b==c) {
                        result = "等边三角形";
                    }else if (a == b || a==c || b==c) {//2.等腰
                        result = "等腰三角形";
                    }else {
                        result = "不等边三角形";
                    }
                }else {
                    result = "非三角形";
                }
            }else {
                result = "请输入大于0的数据";
            }
            return result;
        }

        /**
         * 判断是否构成三角形
         * @param a
         * @param b
         * @param c
         * @return
         */
        private boolean checkTriangle(Integer a,Integer b,Integer c) {
            if (a+b > c && a+c >b && b+c >a) {
                return true;
            }
            return false;
        }

        /**
         * 判断数据合法性
         * @param a
         * @param b
         * @param c
         * @return
         */
        private boolean checkNumber(Integer a,Integer b,Integer c) {
            if (a == null || b == null || c == null) {
                return false;
            }

            if(a <= 0 || b <= 0 || c <=0) {
                return false;
            }
            return true;
        }


}
