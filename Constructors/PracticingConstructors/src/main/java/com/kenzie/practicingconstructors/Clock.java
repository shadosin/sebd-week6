package com.kenzie.practicingconstructors;

public class Clock {
    private int hour;
    private int minute;
    private String period;
    private String timeZone;
    public Clock(){
        this.hour = 12;
        this.minute = 0;
        this.period = "AM";
        this.timeZone="Eastern";
    }
    public Clock(int hour, int minute, String period, String timeZone){
        if(hour <= 12 && hour > 0){
            this.hour = hour;
        }else{
            this.hour = 12;
        }

        if(minute < 60){
            this.minute = minute;
        } else{
            this.minute = 0;
        }
        if(period.equals("PM")||period.equals("AM")){
            this.period = period;
        } else{
            this.period = "AM";
        }
        if     (timeZone.equals("Eastern") ||
                timeZone.equals("Central")||
                timeZone.equals("Pacific") ||
                timeZone.equals("Mountain")){
            this.timeZone = timeZone;
        } else{
            this.timeZone = "Eastern";
        }
    }

    public void setHour(int hour){
        if(hour <= 12 && hour > 0){
            this.hour = hour;
        }

    }
    public int getHour(){ return hour;
    }

    public void setMinute(int minute){
        if(minute < 60){
            this.minute = minute;
        }
    }
    public int getMinute(){ return minute;
    }
    public void setPeriod(String period){
        if(period.equals("PM")||period.equals("AM")){
            this.period = period;
        } else {
            this.period = "AM";
        }
    }
    public String getPeriod(){
        return period;
    }
    public void setTimeZone(String timeZone){
        if     (timeZone.equals("Eastern") ||
                timeZone.equals("Central")||
                timeZone.equals("Pacific") ||
                timeZone.equals("Mountain")){
            this.timeZone = timeZone;
        } else{
            this.timeZone = "Eastern";
        }
    }
    public String getTimeZone(){
        return timeZone;
    }
}