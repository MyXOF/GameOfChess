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

public class GameView extends View{
	private GameControl gameControl;
	private Piece selectedPiece;
	private Paint paint;
	private Bitmap selectImg;

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
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++){
				if(Pieces[i][j].getFlag()!=0){  //是英雄
					ImageView img=(ImageView)findViewById(R.id.imageView[i]);
			        img.setImageResource(R.drawable.heroImage1);				
				}
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
