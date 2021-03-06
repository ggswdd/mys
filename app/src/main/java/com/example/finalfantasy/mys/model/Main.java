package com.example.finalfantasy.mys.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

        @SerializedName("temp")
        @Expose
        private Double temp;
        @SerializedName("temp_min")
        @Expose
        private Double tempMin;
        @SerializedName("temp_max")
        @Expose
        private Double tempMax;
        @SerializedName("pressure")
        @Expose
        private Double pressure;
        @SerializedName("sea_level")
        @Expose
        private Double seaLevel;
        @SerializedName("grnd_level")
        @Expose
        private Double grndLevel;
        @SerializedName("humidity")
        @Expose
        private Integer humidity;
        @SerializedName("temp_kf")
        @Expose
        private Double tempKf;

        public int getTemp() {
            return temp.intValue()-273;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public int getTempMin() {

            return tempMin.intValue();
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public int getTempMax() {
            return tempMax.intValue();
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }

        public double getPressure() {
            double newDouble = new BigDecimal(pressure/1000).setScale(2, RoundingMode.UP).doubleValue();
            return newDouble;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getSeaLevel() {
            return seaLevel;
        }

        public void setSeaLevel(Double seaLevel) {
            this.seaLevel = seaLevel;
        }

        public Double getGrndLevel() {
            return grndLevel;
        }

        public void setGrndLevel(Double grndLevel) {
            this.grndLevel = grndLevel;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

        public Double getTempKf() {
            return tempKf;
        }

        public void setTempKf(Double tempKf) {
            this.tempKf = tempKf;
        }

    }
