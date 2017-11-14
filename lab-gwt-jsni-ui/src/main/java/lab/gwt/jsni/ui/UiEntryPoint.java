package lab.gwt.jsni.ui;

import com.google.gwt.core.client.EntryPoint;

public class UiEntryPoint implements EntryPoint {

  public static String calcularMaioridade(int idade) {
    return idade > 18 ? "Maior" : "Menor";
  }

  public String calcularParOuImpar(int numero) {
    return numero % 2 == 0  ? "Par" : "Ímpar";
  }

  //Exporta método estático.
  public static native void exportarCalcularMaioridade() /*-{
    $wnd.calcularMaioridade = $entry(@lab.gwt.jsni.ui.UiEntryPoint::calcularMaioridade(I));
  }-*/;

  //Exporta método da instância.
  public native void exportarCalcularParOuImpar() /*-{
    var that = this;
    $wnd.calcularParOuImpar = $entry(function(numero) {
      return that.@lab.gwt.jsni.ui.UiEntryPoint::calcularParOuImpar(I)(numero);
    });
  }-*/;

  public void onModuleLoad() {
    exportarCalcularMaioridade();
    exportarCalcularParOuImpar();
  }
}
