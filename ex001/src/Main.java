import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Main {
        public static void main(String[] args) {
              List<Object> minhalista = new ArrayList<>();
            minhalista.add("elemento 1");
            minhalista.add("eu");
            minhalista.add("sou");
            minhalista.add(123);            
            minhalista.add("o");
            minhalista.add("Diogo");

        boolean containsNonString = false; //verifica se existe um não string basicamente da lhe a característica de intruso.



      for (int i = 0; i <= minhalista.size(); i++) {
          Object elementoAtual = minhalista.get(i);
          if (!(elementoAtual instanceof String)) {
              containsNonString = true;
              break; // Se encontrarmos um não-String, não precisamos continuar
          }
      }
          if (containsNonString) {

              System.out.println("Existe um valor não-string na minha list não a posso carregar");


          }else{
              System.out.println(minhalista);
          }
      }
    }

