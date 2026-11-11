package br.pucrs.tfpoo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H1 titulo = new H1("TFPOO-Prj");
        titulo.addClassName(LumoUtility.Margin.NONE);

        Button botao = new Button(
            "Clique aqui",
            evento -> Notification.show(
                "Olá, mundo!",
                3000,
                Notification.Position.TOP_CENTER
            )
        );

        add(titulo, botao);
    }
}
