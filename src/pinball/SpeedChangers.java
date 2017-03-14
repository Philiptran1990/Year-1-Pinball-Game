//Not Used
//package pinball;
//
//import city.cs.engine.*;
//import javax.swing.*;
//import org.jbox2d.common.Vec2;
//
//public abstract class SpeedChangers extends StaticBody implements SensorListener {
//
//    private final Shape flagShape = new BoxShape(2f, 2f);
//    private World world;
//    private Ball ball;
//    private JFrame frame;
//
//    public SpeedChangers(World w, Ball b) {
//        super(w);
//        this.ball = b;
//        Sensor sensor = new Sensor(this, flagShape);
//        sensor.addSensorListener(this);
//    }
//
//    @Override
//    public void beginContact(SensorEvent e) {
//        if (e.getContactBody() == ball) {
//            System.out.println("contact");
//            Vec2 v = ball.getLinearVelocity();
//            ball.setLinearVelocity(v);
//        }
//    }
//
//    @Override
//    public void endContact(SensorEvent e) {
//        if (e.getContactBody() == ball) {
////            ball.getLinearVelocity();
////            ball.setLinearVelocity(new Vec2(0.5f, 0.5f));
//
//        }
//    }
//}
