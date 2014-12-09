package com.example.chessgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View{
	private GameControl gameControl;
	private Piece selectedPiece;
	private Paint paint;
	private Bitmap selectImg;

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		if(this.gameControl == null){
			return;
		}

	}

	public void DrawTable() {

	}

	public void DrawPiece() {

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

}
