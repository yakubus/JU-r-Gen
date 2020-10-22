package pl.jurgen.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.apache.commons.lang3.StringUtils;
import pl.jurgen.services.ParseInputData;

public class StackPaneController {
    @FXML
    Button button;
    @FXML
    TextArea outputText;
    @FXML
    TextArea inputText;

    public StackPaneController() {

        System.out.println("aplikacja wystartowała");
    }

    @FXML
    void initialize() {

    }

    @FXML
    public void generateOnAction() {
        outputText.setText("@Test\n\tpublic void test() {\n\t\tcontroller\n");
        ParseInputData.parseFields(inputText.getText()).forEach((n) ->
                outputText.setText(
                        (n.listValue)
                                ? outputText.getText() + "\t\t\t.withField(\"" + n.label + "\", " + n.value + ")" + "\n"
                                : outputText.getText() + "\t\t\t.withField(\"" + n.label + "\", \"" + n.value + "\")" + "\n"
                )
        );

        outputText.setText(outputText.getText() + "\t\t\t.execute()\n" +
                "\t\t\t.assertExpectations();\n" +
                "\t}");
    }

    @FXML
    public void clearButtonOnAstion() {
        outputText.setText(StringUtils.EMPTY);
        inputText.setText(StringUtils.EMPTY);
    }
}


