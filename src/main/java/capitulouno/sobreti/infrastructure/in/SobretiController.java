package capitulouno.sobreti.infrastructure.in;

import javax.swing.JOptionPane;

import capitulouno.sobreti.application.CreateSobretiUseCase;
import capitulouno.sobreti.domain.entity.Sobreti;
import capitulouno.sobreti.domain.service.SobretiService;

import java.sql.Date;
import java.time.LocalDate;

public class SobretiController {
    private CreateSobretiUseCase createSobretiUseCase;
    private SobretiService sobretiService;

    public SobretiController(CreateSobretiUseCase createSobretiUseCase, SobretiService sobretiService) {
        this.createSobretiUseCase = createSobretiUseCase;
        this.sobretiService = sobretiService;
    }

    public void addSobreti() {
        try {
            // Solicitar al usuario el valor de option_text
            String option_text = JOptionPane.showInputDialog("Ingrese su nombre:");

            // Crear un objeto Sobreti con valores preestablecidos
            Sobreti sobreti = new Sobreti(option_text);
            sobreti.setOption_value(1); // Valor preestablecido
            sobreti.setCreated_at(Date.valueOf(LocalDate.now())); // Fecha actual
            sobreti.setUpdated_at(Date.valueOf(LocalDate.now())); // Fecha actual
            sobreti.setComment_response("Mi nombre"); // Valor preestablecido
            sobreti.setCategorycatalog_id(1); // ID de categoría preestablecido
            sobreti.setParentresponse_id(1); // ID de respuesta padre preestablecido
            sobreti.setQuestion_id(1); // ID de pregunta preestablecido

            // Ejecutar el caso de uso para crear el objeto
            createSobretiUseCase.execute(sobreti);

            // Mensaje de éxito
            JOptionPane.showMessageDialog(null, "Nombre ingresado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al ingresar nombre.");
        }
    }
}
