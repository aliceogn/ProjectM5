public class Item{
    private int quantitat;
    private Article article;

    public int getQuantitat(){
        return this.quantitat;
    }
    public void setQuantitat(int quantitat){
        if(quantitat>0){
            this.quantitat = quantitat;
        }
    }
}