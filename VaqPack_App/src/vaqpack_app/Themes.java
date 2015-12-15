/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaqpack_app;

/**
 *
 * @author mg3Blue
 */
public class Themes {
    
    public String rTheme4(){
        
        return "<style>body{background-color: white;}\r\n"
                +"h1{text-align: center; color: gray; margin-left: 40px;}\r\n"
                +"h2{text-align: center; color: gray; margin-left: 40px;}\r\n"
                +"h3{text-align: center; color: gray; margin-left: 40px;}\r\n"
                +"table{border-collapse: collapse; width: 100%; margin-left: auto; margin-right: auto; border: 1px solid black;}\r\n"
                +"th, td{text-align: center; padding: 8px;}\r\n"
                +"tr:nth-child(odd){background-color: #f2f2f2;}\r\n"
                +"th{background-color: #4CAF50; color: black; text-align: center;}\r\n"
                +"ul{text-align: center; list-style-type: square;}\r\n"
                +"</style>\r\n" + "</head>\r\n" + "<body>\r\n";
    }
    
    public String rTheme2(){
        
        return "<style>body{background-color: white;}\r\n"
                +"h1{text-align: center; color: gray; margin-left: 40px;}\r\n"
                +"h2{border-style: outset; color: gray; margin-left: 40px;}\r\n"
                +"h3{text-align: center; color: gray; margin-left: 40px;}\r\n"
                +"table, th, td{border-style: ridge;}\r\n"
                +"th, td{text-align: left; padding: 8px;}\r\n"
                +"tr:nth-child(odd){background-color: #f2f2f2;}\r\n"
                +"th{background-color: #4CAF50; color: black;}\r\n"
                +"ul{text-align: left; list-style-type: square;}\r\n"
                +"</style>\r\n" + "</head>\r\n" + "<body>\r\n";
    }
    
    public String rTheme3(){
        
        return "<style>body{background-color: white;}\r\n"
                +"h1{text-align: right; color: gray; margin-left: 40px;}\r\n"
                +"h2{border-style: none none solid double; color: gray; margin-left: 40px;}\r\n"
                +"h3{text-align: right; color: gray; margin-left: 40px;}\r\n"
                +"table, th, td{border-style: solid;}\r\n"
                +"th, td{text-align: left; padding: 4px;}\r\n"
                +"tr:nth-child(odd){background-color: #f2f2f2;}\r\n"
                +"th{background-color: #4CAF50; color: black; text-align: center;}\r\n"
                +"ul{text-align: left; list-style-type: circle;}\r\n"
                +"</style>\r\n" + "</head>\r\n" + "<body>\r\n";
    }
    
    public String rTheme1(){
        
        return "<style>body{background-color: white;}\r\n"
                +"h1{text-align: left; color: gray; margin-left: 40px;}\r\n"
                +"h2{text-align: left; color: gray; margin-left: 40px;}\r\n"
                +"h3{text-align: left; color: gray; margin-left: 40px;}\r\n"
                +"table{margin-left: 150px;}\r\n"
                +"th, td{text-align: left; padding: 4px;}\r\n"
                +"td{text-align: left}\r\n"
                +"ul{text-align: left; list-style-type: square; margin-left: 120px;}\r\n"
                +"</style>\r\n" + "</head>\r\n" + "<body>\r\n";
    }
    
    public String bcTheme1(){
        
        return "<style>table{ border: 1px solid black; background-color: white;}</style>" + "</head>\n" + "<body>\n";
    }
    public String bcTheme2(){
        
        return "<style>p{font-weight: bold; } table{ border: 1px solid black; background-color: lightgrey;}</style>" + "</head>\n" + "<body>\n";
    }
    
    
    
    
}
