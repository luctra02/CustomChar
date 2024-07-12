module customChar.core {
    requires transitive com.fasterxml.jackson.databind;
    requires java.net.http;
    
    exports customChar.json;
    exports customChar.core;
}