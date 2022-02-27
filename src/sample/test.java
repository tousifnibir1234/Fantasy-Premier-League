
package sample;
public class test {
    public static void main(String[] args) {
        String name ="tousif";
        String sql = "insert into users values('" +name +"'," + Integer.toString(5)+","+"'"+name +"','" +name +"','"+name +"')";
        System.out.println(sql);
    }
}
