package com.sunjays.capl.utils;

import java.util.ArrayList;
import java.util.List;
/**
 * 判断一个点是否在多边形区域内
 */
import com.sunjays.capl.entity.Area;

public class PointUtils {
	
	public static Boolean isPointInPolygon(Area area, List<Area> areaList) {
		ArrayList<Double> polygonXA = new ArrayList<Double>();
		ArrayList<Double> polygonYA = new ArrayList<Double>();
		for (int i = 0; i < areaList.size(); i++) {
			Area area1 = areaList.get(i);
			polygonXA.add(area1.getPx());
			polygonYA.add(area1.getPy());
		}
		Point point = new Point();
		Boolean flag = point.isPointInPolygon(area.getPx(), area.getPy(),
		polygonXA, polygonYA);
		StringBuffer buffer = new StringBuffer();
		buffer.append("目标点").append("(").append(area.getPx()).append(",")
		.append(area.getPy()).append(")").append("\n");
		buffer.append(flag ? "在" : "不在").append("\t").append("由\n");
		for (int i = 0; i < areaList.size(); i++) {
		Area area1 = areaList.get(i);
		buffer.append(area1.getPoint()).append("; ");
		buffer.append("第"+i+"个点"+area.getPoint()).append("\n");
		System.out.println("第" + (i + 1) + "个点" + area1.getPoint());
		}
		StringBuffer sb = new StringBuffer();
		sb.append("目标点:").append("(").append(area.getPx()).append(",").append(
		area.getPy()).append(")").append("\n");
		System.out.println(sb);
		buffer.append(areaList.size()).append("个点组成的").append(areaList.size())
		.append("边行内");
		System.out.println(buffer.toString());
		System.out.println(point.isPointInPolygon(area.getPx(), area.getPy(), polygonXA,
				polygonYA));
		return point.isPointInPolygon(area.getPx(), area.getPy(), polygonXA,
				polygonYA);
	}
	
	
	/**
     * 通过GPS坐标计算两点间的距离（米）
     * 
     * @param long1
     * @param lat1
     * @param long2
     * @param lat2
     * @return
     */
    public static double Distance(double long1, double lat1, double long2,
            double lat2) {
        double a, b, R;
        R = 6378137; // 地球半径（米）
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2
                * R
                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(sa2)
                        * Math.cos(lat2) * sb2 * sb2));
        return d;
    }
	
}
