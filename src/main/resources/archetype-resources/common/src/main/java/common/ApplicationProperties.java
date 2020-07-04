#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common;


public abstract class ApplicationProperties {

    public static final String APP_NAME = "${rootArtifactId}";
    
    private ApplicationProperties() {
        //
    }

}
