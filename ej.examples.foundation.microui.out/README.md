This example shows how to do the redirection of the standard SystemOut to the display

#Run on the Simulator#
1. Right Click on `ExampleSysOutRedirection`
2. Select Run as -> Run Configuration 
3. Click on new launch configuration
4. Go to Execution tab
5. Select your jpf 
6. Go to Configuration tab
7. Go to Libraries -> EDC
8. Check Use a custom Java output stream
9. Put the class `ej.examples.foundation.microui.out.OutputStreamRedirection`
10. Press Apply
11. Press Run

#Run on the board#
1. Right Click on `ExampleSysOutRedirection`
2. Select Run as -> Run Configuration 
3. Click on new launch configuration
4. Select Execute on EmbJPF
5. Select Build & Deploy
6. Go to Execution tab
7. Select your jpf 
6. Go to Configuration tab
7. Go to Libraries -> EDC
8. Check Use a custom Java output stream
9. Put the class `ej.examples.foundation.microui.out.OutputStreamRedirection`
15. Press Apply
16. Press Run
17. Select Run -> Run Configuration
18. Select MicroEJ Tool
19. Click on new launch configuration
20. Select your jpf 
21. Select program with St link
22. Go to Configuration tab
23. Put the path to the generated .out file
24. Press Apply
25. Press Run
