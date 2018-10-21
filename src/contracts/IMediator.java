package contracts;

import java.util.HashMap;

public interface IMediator {
    void attachAdapter(IAdapter adapter);
    // Nombre d'heures par enseignant
    HashMap<String, Integer> query1() throws Exception;

    // Nombre d'étudiants de France
    Integer query2();

    // Nombre de cours par type (CM/TP/TD)
    HashMap<String, Integer> query3();
}