package com.home.canvasnineninemultiplicationtabledemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class NineNineMultiplicationTableView extends View {

    public static final String TAG = "NineNineMultiplicationTableView";

    private int width, height, color;
    private List<Integer> xCoordinate, yCoordinate;
    private Paint paint;
    private Paint.FontMetricsInt fontMetrics;

    public NineNineMultiplicationTableView(Context context) {
        super(context);
    }

    public NineNineMultiplicationTableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NineNineMultiplicationTableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint({"LongLogTag", "ResourceAsColor"})
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /** 取得畫布的實際寬高 */
        width = canvas.getWidth();
        height = canvas.getHeight();

        /** 初始化畫筆 */
        paint = new Paint();
        color = ContextCompat.getColor(getContext(), R.color.colorMain1);
        paint.setColor(color);  // 設置畫筆顏色
        paint.setStyle(Paint.Style.FILL_AND_STROKE);  // 設置填充樣式
        paint.setStrokeWidth(4);  // 設置畫筆寬度

        /** 繪製10*10的表格 */
        xCoordinate = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            xCoordinate.add(width / 10 / 2 + width / 10 * i);
        }
        yCoordinate = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            yCoordinate.add(height / 10 / 2 + height / 10 * i);
        }
        for (int i = 1; i < 10; i++) {
            canvas.drawLine(2 + width / 10 * i, 0, 2 + width / 10 * i, height, paint);
        }
        canvas.drawLine(2, 0, 2, height, paint);
        canvas.drawLine(width - 2, 0, width - 2, height, paint);
        for (int i = 0; i < 10; i++) {
            canvas.drawLine(0, 0 + height / 10 * i, width, 0 + height / 10 * i, paint);
        }
        canvas.drawLine(0, 2, width, 2, paint);
        canvas.drawLine(0, height - 2, width, height - 2, paint);

        /** 初始化畫筆, 並填上數字符號 */
        paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setTextSize(60);
        paint.setTextAlign(Paint.Align.CENTER);
        fontMetrics = paint.getFontMetricsInt();
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                color = ContextCompat.getColor(getContext(), R.color.colorMain5);
                paint.setColor(color);
                canvas.drawText("⛄", xCoordinate.get(i), yCoordinate.get(i) + fontMetrics.bottom, paint);
                for (int j = 1; j < 11; j++) {
                    color = ContextCompat.getColor(getContext(), R.color.colorMain4);
                    paint.setColor(color);
                    canvas.drawText("" + j, xCoordinate.get(j), yCoordinate.get(i) + fontMetrics.bottom, paint);
                }
            } else {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        color = ContextCompat.getColor(getContext(), R.color.colorMain4);
                        paint.setColor(color);
                        canvas.drawText("" + i, xCoordinate.get(j), yCoordinate.get(i) + fontMetrics.bottom, paint);
                    } else if (j == 1) {
                        color = ContextCompat.getColor(getContext(), R.color.colorMain2);
                        paint.setColor(color);
                        canvas.drawText("" + i, xCoordinate.get(j), yCoordinate.get(i) + fontMetrics.bottom, paint);
                    } else {
                        color = ContextCompat.getColor(getContext(), R.color.colorMain2);
                        paint.setColor(color);
                        canvas.drawText("" + i * j, xCoordinate.get(j), yCoordinate.get(i) + fontMetrics.bottom, paint);
                    }
                }
            }
        }
    }
}
