package com.jqorz.planewar.Utils;

public class ConstantUtil {

    /**
     * 飞机生命值
     */
    public static final int life = 1;//玩家飞机的生命
    public static final int Enemy1_life = 1;//敌军飞机1的生命
    public static final int Enemy2_life = 3;//敌军飞机2的生命
    public static final int Enemy3_life = 6;//敌军飞机3的生命
    /**
     * 补给类型
     */
    public static final int SUPPLY_BULLET_LONG_TIME = 10000;//子弹补给持续时间
    public static int SUPPLY_BULLET_INTERVAL_TIME = 25000;//子弹补给间隔时间
    public static final int SUPPLY_BOMB_INTERVAL_TIME = 35000;//炸弹补给间隔时间

    /**
     * 子弹类型
     */
    public static final int BULLET_RED = 1;//子弹1
    public static final int BULLET_BLUE = 2;//子弹2
    /**
     * 子弹的参数
     */
    public final static int BULLET_TIME = 300;//子弹发射时间间隔
    public final static int BULLET_SPAN = 60;//子弹2的三角形坐标偏移量
    /**
     * 飞机类型
     */
    public static final int ENEMY_TYPE1 = 1;//敌军类型1
    public static final int ENEMY_TYPE2 = 2;//敌军类型2
    public static final int ENEMY_TYPE3 = 3;//敌军类型3
    public static final int HERO_TYPE = 4;//英雄飞机类型
    /**
     * 敌军飞机参数
     */
    public final static int ENEMY_POOL_COUNT = 15;  //敌人对象的数量
    public final static int FIRST_ENEMY_TIME = 2000;//敌军飞机第一次出现的时间

    public static int ENEMY_TIME = 800;//敌军飞机初始出现时间间隔
    public final static int ENEMY_TIME_MUL = 100;//敌军飞机出现时间间隔的递减时间
    public final static int ENEMY_TIME_MIN = 600;//敌军飞机出现最小时间间隔

    public static int ENEMY_VELOCITY = 5;//敌军飞机的初始飞行速度
    public static final int ENEMY_VELOCITY_ADD = 1;//敌军飞机的飞行的递增速度
    public static final int ENEMY_VELOCITY_ADD_MAX = 10;//敌军飞机的递增后最大飞行速度
    public static final int ENEMY_VELOCITY_MAX1 = 18;//敌军飞机1的最大飞行速度
    public static final int ENEMY_VELOCITY_MAX2 = 12;//敌军飞机2的最大飞行速度
    public static final int ENEMY_VELOCITY_AND_TIME = 40000;//敌军飞机的飞行速度的递增时间及敌军飞机出现时间的减少时间



    /**
     * 敌军飞机分数
     */
    public static  int ENEMY_TYPE1_SCORE = 100;//敌军类型1分数
    public static  int ENEMY_TYPE2_SCORE = 300;//敌军类型2分数
    public static  int ENEMY_TYPE3_SCORE = 600;//敌军类型3分数
    /**
     * 飞行速度
     */
    public static final int BULLET_VELOCITY = 18;//子弹的飞行速度
    public static final int Bomb_Velocity = 10;//炸弹补给的飞行速度
    public static final int ChangeBullet_Velocity = 10;//子弹补给的飞行速度
    /**
     * 游戏状态 表示游戏结束
     */
    public static final int STATE_END = 2;
    /**
     * 线程休眠时长
     */
    public static final int RUN_THREAD_SPAN = 100;
    public static final int MOVE_THREAD_SPAN = 10;
    public static final int EXPLORE_THREAD_SPAN = 67;

    /**
     * 作弊码
     */
    public static int CHEAT_CURRENT_STATE = 0;
    public static final int CHEAT_STATE_1 = 101;
    public static final int CHEAT_STATE_2 = 696;
    public static final int CHEAT_STATE_3 = 741;

}