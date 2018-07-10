/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

/**
 *
 * @author kfsarangos_96
 */
public class Pages {

    public static String[] getHomePage() {
        String[] miPage = {
            "HTTP/1.0 200 OK\r\n",
            "Content-Type: text/html; charset=UTF-8\r\n",
            "\r\n",
            "\n<!DOCTYPE html>\n",
            "<html><head><title>Server JAVA</title>\n",
            "<style>" + RulesCss() + "</style>",
            "<body><header>\n"
            + "        <h1>TCP - VEGAS</h1>\n"
            + "        <nav>\n"
            + "            <ul>\n"
            + "                <li>\n"
            + "                        <a href=\"#\" class=\"active\">Home</a>\n"
            + "                </li>\n"
            + "                <li>\n"
            + "                        <a href=\"overview\">Overview</a>\n"
            + "                </li>\n"
            + "                <li>\n"
            + "                        <a href=\"team\">Team</a>\n"
            + "                </li>\n"
            + "            </ul>\n"
            + "\n"
            + "        </nav>\n"
            + "    </header>\n",
            "<main>\n"
            + "        <section class=\"main_content\">\n"
            + "            <p>Bienvenido</p>\n"
            + "        </section>\n"
            + "    </main>\n",
            "<footer>\n"
            + "        <h6>Proyecto Final</h6>\n"
            + "    </footer></body></html>\n"
        };
        return miPage;
    }

    public static String[] getOverviewPage() {
        String[] miPage = {
            "HTTP/1.0 200 OK\r\n",
            "Content-Type: text/html; charset=UTF-8\r\n",
            "\r\n",
            "\n<!DOCTYPE html>\n",
            "<html><head><title>Server JAVA | Overview</title>\n",
            "<style>" + RulesCss() + "</style>",
            "<body><header>\n"
            + "        <h1>TCP - VEGAS</h1>\n"
            + "        <nav>\n"
            + "            <ul>\n"
            + "                <li>\n"
            + "                        <a href=\"/\">Home</a>\n"
            + "                </li>\n"
            + "                <li>\n"
            + "                        <a href=\"#\" class=\"active\">Overview</a>\n"
            + "                </li>\n"
            + "                <li>\n"
            + "                        <a href=\"team\">Team</a>\n"
            + "                </li>\n"
            + "            </ul>\n"
            + "\n"
            + "        </nav>\n"
            + "    </header>\n",
            "<main>\n"
            + "        <section class=\"overview_content\">\n"
            + "            <h2>TCP Vegas</h2>\n"
            + "            <article>\n"
            + "                <p>\n"
            + "                    Si el tamaño de la ventana se controla adecuadamente de modo \n"
            + "                    que no se produzca la pérdida de paquetes en la red, \n"
            + "                    se puede evitar la degradación del rendimiento \n"
            + "                    debido a la ventana estrangulada. \n"
            + "                    Esta es una idea clave de TCP Vegas.\n"
            + "                </p>",
            "<p>\n"
            + "                    TCP Vegas controla su tamaño de ventana al observar \n"
            + "                    los RTT (tiempos de ida y vuelta) de los paquetes \n"
            + "                    que el host emisor ha enviado antes. \n"
            + "                    Si los RTT observados se vuelven grandes, \n"
            + "                    TCP Vegas reconoce que la red comienza a estar congestionada \n"
            + "                    y acelera el tamaño de la ventana. \n"
            + "                    Si, por otro lado, los RTT se vuelven pequeños, \n"
            + "                    el host emisor de TCP Vegas determina que la red se \n"
            + "                    libera de la congestión y aumenta el tamaño de la ventana nuevamente. \n"
            + "                    Por lo tanto, se espera que el tamaño de ventana en una situación ideal \n"
            + "                    converja a un valor apropiado. Más específicamente, \n"
            + "                    en la fase de evitación de la congestión, \n"
            + "                    el tamaño de la ventana se actualiza cuando rtt [sec] \n"
            + "                    es un tiempo de ida y vuelta observado, base_rtt [sec] \n"
            + "                    es el valor más pequeño de los RTT observados, \n"
            + "                    y son algunos valores constantes.\n"
            + "                </p>",
            "<p>\n"
            + "                    TCP Vegas tiene otra característica en su algoritmo de control de congestión: \n"
            + "                    un mecanismo lento de inicio lento. La tasa de aumento del tamaño de la ventana \n"
            + "                    en la fase de inicio lento es la mitad de la que se produce en TCP Tahoe y TCP Reno. \n"
            + "                    A saber, el tamaño de la ventana se incrementa cada vez que se recibe un paquete ACK. \n"
            + "                </p>",
            "<p>\n"
            + "                    TCP Vegas puede lograr un rendimiento superior al 40% más alto que TCP Reno. \n"
            + "                    Sin embargo, no está claro si TCP Vegas funciona bien con TCP Reno o no. \n"
            + "                    Nuestra contribución en este documento es que comparamos los rendimientos \n"
            + "                    de rendimiento de dos versiones en las que comparten el vínculo de cuello de botella, \n"
            + "                    con el fin de discutir la posibilidad de la implementación de TCP Vegas \n"
            + "                    en el futuro de Internet.\n"
            + "                </p>\n"
            + "            </article>\n"
            + "        </section>\n"
            + "    </main>",
            "<footer>\n"
            + "        <h6>Proyecto Final</h6>\n"
            + "    </footer></body></html>\n"
        };
        return miPage;
    }

    public static String[] getTeamPage() {
        String[] miPage = {
            "HTTP/1.0 200 OK\r\n",
            "Content-Type: text/html; charset=UTF-8\r\n",
            "\r\n",
            "\n<!DOCTYPE html>\n",
            "<html><head><title>Server JAVA | Team</title>\n",
            "<style>" + RulesCss() + "</style>",
            "<body><header>\n"
            + "        <h1>TCP - VEGAS</h1>\n"
            + "        <nav>\n"
            + "            <ul>\n"
            + "                <li>\n"
            + "                        <a href=\"/\">Home</a>\n"
            + "                </li>\n"
            + "                <li>\n"
            + "                        <a href=\"overview\">Overview</a>\n"
            + "                </li>\n"
            + "                <li>\n"
            + "                        <a href=\"#\" class=\"active\">Team</a>\n"
            + "                </li>\n"
            + "            </ul>\n"
            + "\n"
            + "        </nav>\n"
            + "    </header>\n",
            "<main>\n"
            + "        <section class=\"team_content\">\n"
            + "            <ul>\n"
            + "                <li>\n"
            + "                    <img src='https://goo.gl/7TiUbM' alt=\"Img team\">\n"
            + "                    <h3>Paul Cuenca</h3>\n"
            + "                </li>",
            "<li>\n"
            + "                    <img src='https://goo.gl/NFxq1E' alt=\"Img team\">\n"
            + "                    <h3>Stalin Carrion</h3>\n"
            + "                </li>",
            "<li>\n"
            + "                    <img src='https://goo.gl/vjm9SZ' alt=\"Img team\">\n"
            + "                    <h3>Klever Sarango</h3>\n"
            + "                </li>\n"
            + "            </ul>\n"
            + "        </section>\n"
            + "    </main>",
            "<footer>\n"
            + "        <h6>Proyecto Final</h6>\n"
            + "    </footer></body></html>\n"
        };
        return miPage;
    }

    public static String RulesCss() {
        return "* {\n"
                + "  margin: 0;\n"
                + "  padding: 0; }\n"
                + "\n"
                + "header {\n"
                + "  width: 100%;\n"
                + "  text-align: center;\n"
                + "  background: linear-gradient(#4040bf, #6666cc);\n"
                + "  overflow: hidden; }\n"
                + "  header h1 {\n"
                + "    padding: 2rem;\n"
                + "    color: #fff; }\n"
                + "  header nav {\n"
                + "    width: 100%;\n"
                + "    overflow: hidden; }\n"
                + "    header nav ul {\n"
                + "      list-style: none;\n"
                + "      width: 100%;\n"
                + "      margin: 1rem 0; }\n"
                + "      header nav ul li {\n"
                + "        margin-bottom: -1px;\n"
                + "        padding: 10px;\n"
                + "        display: inline; }\n"
                + "        header nav ul li a {\n"
                + "          color: #c2c2d6;\n"
                + "          font-size: 16px;\n"
                + "          text-decoration: none;\n"
                + "          padding: 10px;\n"
                + "          border-bottom: 5px solid transparent; }\n"
                + "        header nav ul li a.active {\n"
                + "          border-bottom: 5px solid #1a8cff;\n"
                + "          color: #fff; }\n"
                + "        header nav ul li a:hover {\n"
                + "          border-bottom: 5px solid #c2c2d6;\n"
                + "          color: #23232d; }\n"
                + "\n"
                + "main {\n"
                + "  width: 100%; }\n"
                + "  main .main_content {\n"
                + "    width: 100%;\n"
                + "    height: 60vh;\n"
                + "    text-align: center; }\n"
                + "    main .main_content p {\n"
                + "      font-size: 3rem;\n"
                + "      color: #c2c2d6;\n"
                + "      margin-top: 15%; }\n"
                + "main .overview_content {\n"
                + "    width: 100%;\n"
                + "    text-align: center;\n"
                + "    overflow: hidden; }\n"
                + "    main .overview_content h2 {\n"
                + "      padding: 1.5rem 0; }\n"
                + "    main .overview_content article {\n"
                + "      width: 70%;\n"
                + "      margin: auto; }\n"
                + "      main .overview_content article p {\n"
                + "        font-size: 18px;\n"
                + "        text-align: left;\n"
                + "        color: #52527a;\n"
                + "        font-family: monospace;\n"
                + "        margin-bottom: 1%; }\n"
                + "  main .team_content {\n"
                + "    width: 60%;\n"
                + "    margin: auto;\n"
                + "    min-height: 27em; }\n"
                + "    main .team_content ul {\n"
                + "      list-style: none;\n"
                + "      margin-top: 5rem; }\n"
                + "      main .team_content ul li {\n"
                + "        display: inline-block;\n"
                + "        margin-right: 12%;\n"
                + "        text-align: center; }"
                + "      main .team_content ul li img{\n"
                + "        width: 160px;\n"
                + "        height: 160px;}"
                + "\n"
                + "footer {\n"
                + "  width: 100%;\n"
                + "  background-color: #131339;\n"
                + "  text-align: center;\n"
                + "  color: #fff;\n"
                + "  padding: 1rem 0; }";

    }

}
