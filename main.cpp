#include <cmath>

using namespace std;

int main(){
    //two lengths of the pendulums
    int l1 = 10;
    int l2 = 20;

    // two masses
    int m1 = 10;
    int m2 = 5;

    // gravitational constant
    int g = 9.81; 

    // two angles
    int a1 = 0;
    int a2 = 90;

    while(true){
        // calculate positions
        int x1 = l1 * sin(a1);
        int y1 = -l1 * cos(a1);
        int x2 = x1 + l2 * sin(a2);
        int y2 = y1 - l2 * cos(a2);

        int a1v = -g * (2 * m1 + m2) * sin(a1) - m2 * g * sin(a1 - 2 * a2) - 2 * sin(a1 - a2) * m2 * ();
        int a2v;

        // calculate velocities
        int x1v = a1v * l1 * cos(a1);
        int y1v = a1v * l1 * sin(a1);
        int x2v = x1v + a2v * l2 * cos(a2);
        int y2v = y1v + a2v * l2 * sin(a2);

        int a1a;
        int a2a;

        // calculate accelerations
        int x1a = -(a1v * a1v) * l1 * sin(a1) + a1a * l1 * cos(a1);
        int y1a = (a1v * a1v) * l1 * cos(a1) + a1a * l1 * sin(a1);
        int x2a = x1a - (a2v * a2v) * l2 * sin(a2) + a2a * l2 * cos(a2);
        int y2a = y1a + (a2v * a2v) * l2 * cos(a2) + a2a * l2 * sin(a2);
    }
}