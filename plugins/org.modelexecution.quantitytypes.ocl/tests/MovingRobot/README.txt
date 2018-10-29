In order to execute the Robot specifications, the files in the directory 
plugins\org.modelexecution.quantitytypes.ocl\oclextensions
should be placed first in the oclExtensions folder of the USE/OCL instalation. 
They contain some of the operations on OCL Real numbers that are needed in the Robot
specifications, such as sin(), cos(), sqrt(), etc.

The rest of the files in this folder are:

a) For the Robot with Plain UML:

* MovingRobot-NoQuantities.use: specs of the Robot using plain UML (ie. w/o Quantities)
* MovingRobot-NoQuantities_default.clt: diagrammatic info for these specs
* Robot-NoQuantities.soil: set of SOIL commands to execute the MovingRobot-NoQuantities.use specs
* Robot-NoQuantities-output.txt: output of executing the SOIL commands

To execute these specs, in the USE/OCL console, execute:

use> open MovingRobot-NoQuantities.use
use> open Robot-NoQuantities.soil

a) For the Robot with Quantities:

* MovingRobot.use: specs of the Robot using Quantities
* MovingRobot_default.clt: diagrammatic info for these specs
* Robot.soil: set of SOIL commands to execute the MovingRobot.use specs
* Robot-output.txt: output of executing the SOIL commands

To execute these specs, in the USE/OCL console, execute:

use> open MovingRobot.use
use> open Robot.soil

