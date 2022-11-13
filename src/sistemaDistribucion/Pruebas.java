/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaDistribucion;

/**
 *
 * @author Pérez, G. 249454 ; Ribas, I. 242158
 */
public class Pruebas {
    
    private final Obligatorio s;
    
    public Pruebas (Obligatorio s) {
        this.s = s;
    }

    public void pruebasCreacionSistema_1(Obligatorio s, Prueba p) {

        p.ver(this.s.crearSistemaDeDistribucion(5).resultado, Retorno.Resultado.OK, "Se crea el sistema con capacidad 10");
        p.ver(this.s.crearSistemaDeDistribucion(-1).resultado, Retorno.Resultado.ERROR_1, "No se crea el sistema, capacidad <=0");
        p.ver(this.s.crearSistemaDeDistribucion(10).resultado, Retorno.Resultado.OK, "Se crea el sistema con capacidad 12");
    }

    public void pruebasRegistroClientes(Obligatorio s, Prueba p) {
        p.ver(this.s.agregarCliente("Micaela Pérez", "111", 99368826, "Lorenzo Martínez 123").resultado, Retorno.Resultado.OK, "Se registra el cliente: Micaela Pérez");
        p.ver(this.s.agregarCliente("Romina Álvarez", "222", 98999111, "Carlos Quijano 222").resultado, Retorno.Resultado.OK, "Se registra el cliente: Romina Álvarez");
        p.ver(this.s.agregarCliente("Felipe Muñoz", "333", 97333333, "Luis Franzini 333").resultado, Retorno.Resultado.OK, "Se registra el cliente: Felipe Muñoz");
        p.ver(this.s.agregarCliente("Pedro González", "111", 94222222, "Mercedes 888").resultado, Retorno.Resultado.ERROR_1, "Ya existe un cliente con rut 111");
        p.ver(this.s.agregarCliente("Pedro González", "444", 94222222, "Mercedes 888").resultado, Retorno.Resultado.OK, "Se registra el cliente: Pedro González");
        p.ver(this.s.agregarCliente("Ignacio Alcorta", "888", 91333123, "Uruguay 123").resultado, Retorno.Resultado.OK, "Se registra el cliente: Ignacio Alcorta");
        p.ver(this.s.agregarCliente("Nicole Bañales", "222", 92323111, "Carlos Berg 934").resultado, Retorno.Resultado.ERROR_1, "Ya existe un cliente con rut 222");

        p.ver(this.s.listarClientesOrdenado().resultado, Retorno.Resultado.OK, "Se listan 5 clientes");
    }

    public void pruebasRegistroCamion(Obligatorio s, Prueba p) {
        p.ver(this.s.agregarCamion("MEC4452", 2000).resultado, Retorno.Resultado.OK, "Se registra el camión de matrícula MEC4452");
        p.ver(this.s.agregarCamion("OOO1111", 4000).resultado, Retorno.Resultado.OK, "Se registra el camión de matrícula OOO1111");
        p.ver(this.s.agregarCamion("WEC3234", 3000).resultado, Retorno.Resultado.OK, "Se registra el camión de matrícula WEC3234");
        p.ver(this.s.agregarCamion("MEC4452", 1000).resultado, Retorno.Resultado.ERROR_1, "No se registra. Ya existe un camión de matrícula MEC4452");
        p.ver(this.s.agregarCamion("TTT4500", 1000).resultado, Retorno.Resultado.OK, "Se registra el camión de matrícula TTT4500");
        p.ver(this.s.agregarCamion("IOE2893", 0).resultado, Retorno.Resultado.ERROR_2, "No se registra. La carga del camion es <= 0");
        p.ver(this.s.agregarCamion("COC3100", 3000).resultado, Retorno.Resultado.OK, "Se registra el camión de matrícula COC3100");
        p.ver(this.s.listarCamiones().resultado, Retorno.Resultado.OK, "Se listan 5 camiones");
        /*
        *********** Ejemplo de reporte de camiones listados ****************
        MEC4452 - 2000
        OOO1111 - 4000
        WEC3234 - 3000
        TTT4500 - 1000 
        COC3100 - 3000
         */
    }

    public void pruebasRegistroProducto(Obligatorio s, Prueba p) {
        p.ver(this.s.registrarProducto("Shampoo Lor", "Shampoo de 1l").resultado, Retorno.Resultado.OK, "Se registra el producto Shampoo Lor");
        p.ver(this.s.registrarProducto("Candado St", "Candados de acero").resultado, Retorno.Resultado.OK, "Se registra el producto Candado St");
        p.ver(this.s.registrarProducto("Bicicleta Ronda", "Bicicleta rodado 20").resultado, Retorno.Resultado.OK, "Se registra el producto Bicicleta Ronda");
        p.ver(this.s.registrarProducto("Televisión Marc", "Televisión de 32 pulgadas").resultado, Retorno.Resultado.OK, "Se registra el producto Televisión Marc");
        p.ver(this.s.registrarProducto("Monopatin", "Monopatn para niños").resultado, Retorno.Resultado.OK, "Se registra el producto Monopatin");
        p.ver(this.s.registrarProducto("Candado St", "Candados de hierro").resultado, Retorno.Resultado.ERROR_1, "No se registra. Ya existe un producto de nombre Candado St");
        p.ver(this.s.registrarProducto("Laptop Stu", "").resultado, Retorno.Resultado.ERROR_2, "No se registra. La descripción esta vacía");
        p.ver(this.s.registrarProducto("Laptop Stu", "Laptop de 17 pulgadas").resultado, Retorno.Resultado.OK, "Se registra el producto Laptop Stu");
        p.ver(this.s.registrarProducto("Barra de ejercicio", "Barra de ejercicio de hierro").resultado, Retorno.Resultado.OK, "Se registra el producto Barra de ejercicio");

        p.ver(this.s.listarProductos().resultado, Retorno.Resultado.OK, "Se listan 7 productos");
    }

    public void pruebasAltaSotck(Obligatorio s, Prueba p) {
        p.ver(this.s.altaDeStockDeProducto("MEC4452", 1, 50, 1000).resultado, Retorno.Resultado.OK, "Se agregan 1000 unidades de stock al producto Shampoo Lor");
        p.ver(this.s.altaDeStockDeProducto("OOO1111", 1, 60, 2000).resultado, Retorno.Resultado.OK, "Se agregan 2000 unidades de stock al producto Shampoo Lor");
        p.ver(this.s.altaDeStockDeProducto("MEC4452", 8, 70, 1000).resultado, Retorno.Resultado.ERROR_2, "No se registra. No existe el producto de código 8");
        p.ver(this.s.altaDeStockDeProducto("MEC4452", 3, 2, 20).resultado, Retorno.Resultado.OK, "Se agregan 20 unidades de stock al producto Bicicleta Ronda");
        p.ver(this.s.altaDeStockDeProducto("OOO1111", 6, 17, 50).resultado, Retorno.Resultado.OK, "Se agregan 50 unidades de stock al producto Laptop Stu");
        p.ver(this.s.altaDeStockDeProducto("XCX5622", 1, 11, 50).resultado, Retorno.Resultado.ERROR_1, "No se registra. No existe el camion de matricula XCX5622");
        p.ver(this.s.altaDeStockDeProducto("WEC3234", 2, 13, 1500).resultado, Retorno.Resultado.OK, "Se agregan 1500 unidades de stock al producto Candado St");
        p.ver(this.s.altaDeStockDeProducto("WEC3234", 2, 14, 500).resultado, Retorno.Resultado.OK, "Se agregan 500 unidades de stock al producto Candado St");
        p.ver(this.s.altaDeStockDeProducto("WEC3234", 2, 19, 0).resultado, Retorno.Resultado.ERROR_3, "No se registra. Las unidades no puedes ser <=3");
        p.ver(this.s.altaDeStockDeProducto("TTT4500", 5, 99, 30).resultado, Retorno.Resultado.OK, "Se agregan 30 unidades de stock al producto Monopatin");
        p.ver(this.s.altaDeStockDeProducto("WEC3234", 2, 50, 90).resultado, Retorno.Resultado.ERROR_4, "No se registra. El número de caja 50 ya existe");
        p.ver(this.s.altaDeStockDeProducto("TTT4500", 4, 108, 10).resultado, Retorno.Resultado.OK, "Se agregan 10 unidades de stock al producto Televisión Marc");
        p.ver(this.s.altaDeStockDeProducto("TTT4500", 4, 109, 10).resultado, Retorno.Resultado.OK, "Se agregan 10 unidades de stock al producto Televisión Marc");
        p.ver(this.s.altaDeStockDeProducto("TTT4500", 4, 110, 10).resultado, Retorno.Resultado.OK, "Se agregan 10 unidades de stock al producto Televisión Marc");
        p.ver(this.s.altaDeStockDeProducto("TTT4500", 4, 111, 10).resultado, Retorno.Resultado.ERROR_5, "No se registra. La fabrica tiene un tope de 10 cajas");

        p.ver(this.s.listarProductos().resultado, Retorno.Resultado.OK, "Se listan 7 productos");
    }

    public void pruebasRetiroDeProducto(Obligatorio s, Prueba p) {

        p.ver(this.s.retiroDeProducto("MEC4452", "111", 1, 2200).resultado, Retorno.Resultado.OK, "Se retiran 2200 unidades del producto Shampoo Lor");
        p.ver(this.s.retiroDeProducto("MEC4452", "111", 1, 600).resultado, Retorno.Resultado.OK, "Se retiran 600 unidades del producto Shampoo Lor");
        p.ver(this.s.retiroDeProducto("OOO1111", "222", 2, 2000).resultado, Retorno.Resultado.OK, "Se retiran 2000 unidades del producto Candado St");
        p.ver(this.s.retiroDeProducto("OOO1111", "222", 2, 1000).resultado, Retorno.Resultado.OK, "Se genera una orden pendiente por 1000 unidades del producto Candado St");
        p.ver(this.s.retiroDeProducto("MEC4452", "333", 6, 40).resultado, Retorno.Resultado.OK, "Se retiran 40 unidades del producto Laptop Stu");
        p.ver(this.s.retiroDeProducto("VND2344", "333", 6, 40).resultado, Retorno.Resultado.ERROR_1, "No se realiza el retiro. No existe un camión de matrícula VND2344");
        p.ver(this.s.retiroDeProducto("MEC4452", "190", 6, 40).resultado, Retorno.Resultado.ERROR_2, "No se realiza el retiro. No existe cliente de rut 190");
        p.ver(this.s.retiroDeProducto("MEC4452", "333", 10, 40).resultado, Retorno.Resultado.ERROR_3, "No se realiza el retiro. No existe un producto de código 10");
        p.ver(this.s.retiroDeProducto("TTT4500", "444", 7, 1000).resultado, Retorno.Resultado.OK, "Se genera una orden pendiente por 1000 unidades del producto Barra de ejercicio");
        p.ver(this.s.retiroDeProducto("TTT4500", "444", 3, 30).resultado, Retorno.Resultado.OK, "Se retiran 20 unidades del producto Bicicleta Ronda. Se genera una orden pendiente por 10 unidades del producto Bicicleta Ronda");
        p.ver(this.s.retiroDeProducto("TTT4500", "444", 3, 30).resultado, Retorno.Resultado.OK, "Se genera una orden pendiente por 30 unidades del producto Bicicleta Ronda");

        p.ver(this.s.listarProductos().resultado, Retorno.Resultado.OK, "Se listan 7 productos");
        
        p.ver(this.s.listarOrdenesPendientes(1).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 1: No hay");
        p.ver(this.s.listarOrdenesPendientes(2).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 2: Orden pendiente:1000u");
        p.ver(this.s.listarOrdenesPendientes(3).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 3: Orden pendiente:10u - Orden pendiente:30u");
        p.ver(this.s.listarOrdenesPendientes(4).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 4: No hay");
        p.ver(this.s.listarOrdenesPendientes(5).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 5: No hay");
        p.ver(this.s.listarOrdenesPendientes(6).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 6: No hay");
        p.ver(this.s.listarOrdenesPendientes(7).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 7: Orden pendiente:1000u");
        p.ver(this.s.listarOrdenesPendientes(11).resultado, Retorno.Resultado.ERROR_1, "No existe el producto de código 11");

        p.ver(this.s.ultimoProductoRegistrado().resultado, Retorno.Resultado.OK, "Producto: Cod. Prod: 7 - Barra de ejercicio - 0 unidades");

        p.ver(this.s.altaDeStockDeProducto("MEC4452", 2, 194, 2000).resultado, Retorno.Resultado.OK, "Se agregan 2000 unidades de stock al producto Candado St. Se hace retiro pendiente de 1000u ");
        p.ver(this.s.listarOrdenesPendientes(2).resultado, Retorno.Resultado.OK, "Ordenes pendientes del producto 2: No hay");
        p.ver(this.s.listarProductos().resultado, Retorno.Resultado.OK, "Se listan 7 productos");        
    }

    public void pruebasDeBaja(Obligatorio s, Prueba p) {

        p.ver(this.s.eliminarCamion("COC3100").resultado, Retorno.Resultado.OK, "Se elimina el camión COC3100");
        p.ver(this.s.eliminarCamion("TUT3100").resultado, Retorno.Resultado.ERROR_1, "No se elimina. No existe camion con matricula TUT3100");
        p.ver(this.s.eliminarCamion("MEC4452").resultado, Retorno.Resultado.ERROR_2, "No se elimina. El camion MEC4452 tiene entregas realizadas");
        p.ver(this.s.eliminarCamion("OOO1111").resultado, Retorno.Resultado.ERROR_2, "No se elimina. El camion OOO1111 tiene entregas realizadas");

        p.ver(this.s.listarCamiones().resultado, Retorno.Resultado.OK, "Se listan 4 camiones");

        p.ver(this.s.eliminarCliente("888").resultado, Retorno.Resultado.OK, "Se elimina el cliente 888");
        p.ver(this.s.eliminarCliente("123").resultado, Retorno.Resultado.ERROR_1, "No se elimina. No existe cliente con rut 123");
        p.ver(this.s.eliminarCliente("111").resultado, Retorno.Resultado.ERROR_2, "No se elimina. El cliente 111 tiene entregas realizadas");

        p.ver(this.s.listarClientesOrdenado().resultado, Retorno.Resultado.OK, "Se listan 4 clientes");
    }

    public void pruebasDeReporteDeEnviosXProducto(Obligatorio s, Prueba p) {

        p.ver(this.s.reporteDeEnviosDeProductos().resultado, Retorno.Resultado.OK, "Se muestra el reporte de evíos por productos");

        /*
        *********** Ejemplo de reporte de envíos por producto a cliente ****************
        
        
                         333      111     444    222
        Cod. Prod: 1      0        2       0      0
        Cod. Prod: 2      0        0       0      3
        Cod. Prod: 3      0        0       1      0
        Cod. Prod: 4      0        0       0      0
        Cod. Prod: 5      0        0       0      0
        Cod. Prod: 6      1        0       0      0
        Cod. Prod: 7      0        0       0      0
         */
    }
    
    public void probar () {
        this.pruebasCreacionSistema_1(this.s, new Prueba());
        this.pruebasRegistroClientes(this.s, new Prueba());
        this.pruebasRegistroProducto(this.s, new Prueba());
        this.pruebasRegistroCamion(this.s, new Prueba());
        this.pruebasAltaSotck(this.s, new Prueba());
        this.pruebasRetiroDeProducto(this.s, new Prueba());
        this.pruebasDeReporteDeEnviosXProducto(this.s, new Prueba ());
        this.pruebasDeBaja(this.s, new Prueba ());
    }
}
