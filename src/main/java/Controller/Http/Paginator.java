package Controller.Http;

public class Paginator {
    private final int limite;//elementi per pagine
    private final int offset;//numero pagine


    public Paginator(int page,String servlet){
        int itemsPerPage=0;
        if(servlet.compareToIgnoreCase("CategoriaServlet")==0){
            itemsPerPage=20;
        }
        if(servlet.compareToIgnoreCase("UtenteServlet")==0){
            itemsPerPage=20;
        }
        if(servlet.compareToIgnoreCase("RispostaServlet")==0){
            itemsPerPage=25;
        }
        if(servlet.compareToIgnoreCase("DiscussioneServlet")==0){
            itemsPerPage=20;
        }

        this.limite=itemsPerPage;
        this.offset=(page==1)? 0:(page-1)*itemsPerPage+1;

    }


    public int getLimite() {
        return limite;
    }

    public int getOffset() {
        return offset;
    }
    public int getPages(int size){//Quante pagine devo creare
        int addPage=(size % limite==0) ? 0 : 1; //pagino elementi in size taglie
        return (size/limite)+ addPage;
    }
}
