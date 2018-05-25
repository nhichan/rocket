public class Main {//bên trong class nào cũng chỉ để khai báo

    public static void main(String[] args) {//khai báo 1 hàm tên là main, code chỉ tồn tại bên trong 1 hàm
        // code k tồn tại bên trong class

        GameWindow gameWindow = new GameWindow();//new nghĩa là tạo ra 1 object mới lưu vào gameWindow
        // vì Main dùng GameWindow nên phải khai báo
        //GameWindow là tên kiểu của biến gameWindow

        //class là khái niệm, chỉ ra mọi thứ
        // đã nằm sau new thì thành object
        gameWindow.gameLoop(); //()có nghĩa là gọi //phải dùng gameLoop trong GameWindow
    }
}


//class chỉ liệt kê tính năng
//object bổ sung các thuộc tính cho class
// bản chất của hướng đối tượng là gom biến và hàm với nhau