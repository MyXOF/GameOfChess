package com.example.chessgame;



import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GameView extends View{
	private GameControl gameControl;
	private Piece selectedPiece;
	private TableLayout gameView;
    private ImageView[][] g_gameView;
    


    public GameView(Context context,GameControl Control,TableLayout m_gameview) {
		super(context);
		setGameControl(Control);
		setGameView(m_gameview);
		GenerateTable(context);

		
	}
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		
}


	
    public void GenerateTable(Context context) {
	    int Col = gameControl.GetCol();
	    int Row = gameControl.GetRow();
	    
	    int iWidth = AdjustMapSize(Col, Row);
	    int iHeight = iWidth;
	    AddRowToTable(context, Col, Row, iWidth, iHeight);
	    ResetTable();
    }
    
    public void AddRowToTable(Context context,int Col,int Row,int iWidth,int iHeight){
	    for(int i = 0; i < Col; i++) {
	    	TableRow row = new TableRow(context);
	    	for(int j = 0; j < Row; j++) {
	    		g_gameView[i][j] = new ImageView(context);
	    		g_gameView[i][j].setMaxHeight(iHeight);
	    		g_gameView[i][j].setMaxWidth(iWidth);
	    		g_gameView[i][j].setAdjustViewBounds(true);
	    		row.addView(g_gameView[i][j]);
	    	}
	        gameView.addView(row);
	    }
    }
    
    public int AdjustMapSize(int Col,int Row) {
	    float scaleWidth;
	    int iHeight;
	    int iWidth;
	    
	    scaleWidth = gameView.getResources().getDisplayMetrics().widthPixels;  
	    
	    iHeight = iWidth = (int) (scaleWidth / Col);
	    RelativeLayout.LayoutParams tableParams = (RelativeLayout.LayoutParams) gameView.getLayoutParams();
	    tableParams.height = iHeight * Row;
	    gameView.setLayoutParams(tableParams);
	    
	    SetGameConfig(iWidth, iHeight);
	    
	    return iWidth;
	}
    
    public void ResetTable() {
    	int Col = gameControl.GetCol();
 	    int Row = gameControl.GetRow();
 	    
 	   for(int i = 0; i < Col; i++) {
	    	
	    	for(int j = 0; j < Row; j++) {
	    		
	    		g_gameView[i][j].setImageResource(R.drawable.blank);

	    	}

	    }
	}
	
	public void StartGame(){
		this.gameControl.start();
		this.postInvalidate();
	}
	
	public void UpdateAppearance(){
		if(this.gameControl == null){
			return;
		}
		UpdateMap();
	}
	
	public void UpdateMap(){
		Piece[][] Pieces= gameControl.getPieces();
		int Col = gameControl.GetCol();
		int Row = gameControl.GetRow();
        int pt_x = 0,pt_y = 0;

        Hero hro = new Hero();
		for(int i=0;i<Row;i++){
			for(int j=0;j<Col;j++){
				if(Pieces[i][j].getFlag()==1){ 
                    g_gameView[i][j].setImageResource(R.drawable.hero1);
                    if(1 == gameControl.getTurn()) {
                       pt_x = i;
                       pt_y = j;
                       hro = gameControl.getM_hero();                       
                     }				
				}
                if(Pieces[i][j].getFlag()==2){   
                    g_gameView[i][j].setImageResource(R.drawable.hero2);
                    if(2 == gameControl.getTurn()) {
                       pt_x = i;
                       pt_y = j;
                       hro = gameControl.getE_hero();
                     }
                 }
                if(Pieces[i][j].getFlag()==0){
                	g_gameView[i][j].setImageResource(R.drawable.blank);
                }
			}
		}
		ShowRange(pt_x, pt_y, hro);	
	}
		
	public void ShowRange(int pt_x,int pt_y,Hero hro){
		int Col = gameControl.GetCol();
		int Row = gameControl.GetRow();
		Piece[][] pieces = gameControl.getPieces();
		
        for(int i=0;i<Row;i++){
        	for(int j=0;j<Col;j++){
				if(Math.abs(i-pt_x)+Math.abs(j-pt_y) <= hro.getMove_range()){  
					if((i== pt_x) && (j == pt_y)){
						continue;
					}
					if(pieces[i][j].getFlag() == (3-gameControl.getTurn())){
						if(Math.abs(i-pt_x)+Math.abs(j-pt_y) <= hro.getAttack_range()){
							g_gameView[i][j].setImageResource(R.drawable.herounderattackrange);
							continue;
						}
						continue;
						
					}
					if(Math.abs(i-pt_x)+Math.abs(j-pt_y) <= hro.getAttack_range()){
						g_gameView[i][j].setImageResource(R.drawable.rangeattack);
						continue;
					}
					g_gameView[i][j].setImageResource(R.drawable.range);
						
				}
                                
			}
        }
	}

	public void SetGameConfig(int iwidth,int iheight) {
		GameConf gameConfig = gameControl.GetConfig();
		gameConfig.setPIC_WIDTH(iwidth);
		gameConfig.setPIC_HEIGHT(iheight);
	}
	public GameControl getGameControl() {
		return gameControl;
	}

	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
		g_gameView = new ImageView[gameControl.GetRow()][gameControl.GetCol()];
	}

	public Piece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	public TableLayout getGameView() {
		return gameView;
	}
	public void setGameView(TableLayout gameView) {
		this.gameView = gameView;
	}

}
