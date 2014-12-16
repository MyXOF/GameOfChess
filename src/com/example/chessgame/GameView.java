package com.example.chessgame;

//import android.R;

import android.R;
import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import MainActivity.MainActivity;

public class GameView extends View{
	private GameControl gameControl;
	private Piece selectedPiece;
	private Paint paint;
	private Bitmap selectImg;
        static ImageView[][] g_gameView = new ImageView[10][10];
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//DrawTable();
		
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		if(this.gameControl == null){
			return;
		}
		Piece[][] Pieces= gameControl.getPieces();
                int pt_x,pt_y;
                Hero hro;
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++){
				if(Pieces[i][j].getFlag()==1){  //是己方英雄
					//ImageView img=(ImageView)findViewById(R.id.imageView[i]);
			       // img.setImageResource(R.drawable.heroImage1);
                                    g_gameView[i][j].setImageResource(R.drawable.hero1);
                                    if(1 == gameControl.getTurn()) {
                                       pt_x = i; pt_y = j;
                                       hro = gameControl.getM_hero();
                                     }				
				}
                                if(Pieces[i][j].getFlag()==2){   //是敌人英雄
                                    g_gameView[i][j].setImageResource(R.drawable.hero2);
                                    if(2 == gameControl.getTurn()) {
                                       pt_x = i; pt_y = j;
                                       hro = gameControl.getE_hero();
                                     }
                                 }
                                if(Pieces[i][j].getFlag()==0){
                                 g_gameView[i][j].setImageResource(R.drawable.blank);
                                }
			}
                   for(int i=0;i<9;i++)
			for(int j=0;j<9;j++){
				if(Math.abs(i-pt_x)+Math.abs(j-pt_y) < hro.move_range){  //在移动范围内
                                    g_gameView[i][j].setImageResource(R.drawable.range);
                                    g_gameView[i][j].setAlpht(120);			
				}
                                
			}


	}

        public void GenerateTable(MainActivity mainActivity) {
        float scale;
        int iHeight;
        int iWidth;
        TableLayout gameView = (TableLayout)findViewById(R.id.GameView);
        scale = mainActivity.getResources().getDisplayMetrics().widthPixels;  
        iHeight = iWidth = (int) (scale / 9);
        for(int i = 0; i < 9; i++) {
        	TableRow row = new TableRow(this);
        	for(int j = 0; j < 9; j++) {
        		g_gameView[i][j] = new ImageView(mainActivity);
        		g_gameView[i][j].setMaxHeight(iHeight);
        		g_gameView[i][j].setMaxWidth(iWidth);
        		g_gameView[i][j].setAdjustViewBounds(true);
        		g_gameView[i][j].setImageResource(R.drawable.range);
        		row.addView(g_gameView[i][j]);
        	}
            gameView.addView(row);
        }
    }

	public void DrawTable() {  //画每个格子
		/*for(int i=0;i<10;i++)
			for(int j=0;j<10;j++){
				selectImg= BitmapFactory.decodeFile("/sdcard/picturetest/a1.jpg", opts);
				selectedPiece.setImgBitmap(selectImg);
				imageView.setImageBitmap(selectImg);
			}*/
	}

	public void DrawPiece() {
		//for(int i=)
	}
	
	public void StartGame(){
		this.gameControl.start();
		this.postInvalidate();
	}

	public GameControl getGameControl() {
		return gameControl;
	}

	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	public Piece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}

}
