package com.ksa.web.wro4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 解决 jsessionid 产生的问题。
 *
 * @author 麻文强
 *
 * @since
 */
public class HttpServletRequestWrapper implements HttpServletRequest {
    
    protected HttpServletRequest request;
    
    public HttpServletRequestWrapper( HttpServletRequest request ) {
        this.request = request;
    }

    @Override
    public Object getAttribute( String name ) {
        return request.getAttribute( name );
    }

    @SuppressWarnings( "rawtypes" )
    @Override
    public Enumeration getAttributeNames() {
        return request.getAttributeNames();
    }

    @Override
    public String getCharacterEncoding() {
        return request.getCharacterEncoding();
    }

    @Override
    public void setCharacterEncoding( String env ) throws UnsupportedEncodingException {
        request.setCharacterEncoding( env );
    }

    @Override
    public int getContentLength() {
        return request.getContentLength();
    }

    @Override
    public String getContentType() {
        return request.getContentType();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return request.getInputStream();
    }

    @Override
    public String getParameter( String name ) {
        return request.getParameter( name );
    }

    @SuppressWarnings( "rawtypes" )
    @Override
    public Enumeration getParameterNames() {
        return request.getParameterNames();
    }

    @Override
    public String[] getParameterValues( String name ) {
        return request.getParameterValues( name );
    }

    @SuppressWarnings( "rawtypes" )
    @Override
    public Map getParameterMap() {
        return request.getParameterMap();
    }

    @Override
    public String getProtocol() {
        return request.getProtocol();
    }

    @Override
    public String getScheme() {
        return request.getScheme();
    }

    @Override
    public String getServerName() {
        return request.getServerName();
    }

    @Override
    public int getServerPort() {
        return request.getServerPort();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return request.getReader();
    }

    @Override
    public String getRemoteAddr() {
        return request.getRemoteAddr();
    }

    @Override
    public String getRemoteHost() {
        return request.getRemoteHost();
    }

    @Override
    public void setAttribute( String name, Object o ) {
        request.setAttribute( name, o );
    }

    @Override
    public void removeAttribute( String name ) {
        request.removeAttribute( name );
    }

    @Override
    public Locale getLocale() {
        return request.getLocale();
    }

    @SuppressWarnings( "rawtypes" )
    @Override
    public Enumeration getLocales() {
      return request.getLocales();
    }

    @Override
    public boolean isSecure() {
        return request.isSecure();
    }

    @Override
    public RequestDispatcher getRequestDispatcher( String path ) {
        return request.getRequestDispatcher( path );
    }

    @SuppressWarnings( "deprecation" )
    @Override
    public String getRealPath( String path ) {
        return request.getRealPath( path );
    }

    @Override
    public int getRemotePort() {
        return request.getRemotePort();
    }

    @Override
    public String getLocalName() {
        return request.getLocalName();
    }

    @Override
    public String getLocalAddr() {
        return request.getLocalAddr();
    }

    @Override
    public int getLocalPort() {
        return request.getLocalPort();
    }

    @Override
    public String getAuthType() {
        return request.getAuthType();
    }

    @Override
    public Cookie[] getCookies() {
        return request.getCookies();
    }

    @Override
    public long getDateHeader( String name ) {
        return request.getDateHeader( name );
    }

    @Override
    public String getHeader( String name ) {
        return request.getHeader( name );
    }

    @SuppressWarnings( "rawtypes" )
    @Override
    public Enumeration getHeaders( String name ) {
        return request.getHeaders( name );
    }

    @SuppressWarnings( "rawtypes" )
    @Override
    public Enumeration getHeaderNames() {
        return request.getHeaderNames();
    }

    @Override
    public int getIntHeader( String name ) {
        return request.getIntHeader( name );
    }

    @Override
    public String getMethod() {
        return request.getMethod();
    }

    @Override
    public String getPathInfo() {
        return request.getPathInfo();
    }

    @Override
    public String getPathTranslated() {
        return request.getPathTranslated();
    }

    @Override
    public String getContextPath() {
        return request.getContextPath();
    }

    @Override
    public String getQueryString() {
        return request.getQueryString();
    }

    @Override
    public String getRemoteUser() {
        return request.getRemoteUser();
    }

    @Override
    public boolean isUserInRole( String role ) {
        return request.isUserInRole( role );
    }

    @Override
    public Principal getUserPrincipal() {
        return request.getUserPrincipal();
    }

    @Override
    public String getRequestedSessionId() {
        return request.getRequestedSessionId();
    }

    @Override
    public String getRequestURI() {
        // 解决 JSession 的问题
        String uri = request.getRequestURI();
        if( uri != null ) {
            int index = uri.toLowerCase().indexOf( ";jsessionid" );
            if( index >= 0 ) {
                uri = uri.substring( 0, index );
            }
        }
        return uri;
    }

    @Override
    public StringBuffer getRequestURL() {
        return request.getRequestURL();
    }

    @Override
    public String getServletPath() {
        return request.getServletPath();
    }

    @Override
    public HttpSession getSession( boolean create ) {
        return request.getSession( create );
    }

    @Override
    public HttpSession getSession() {
        return request.getSession();
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return request.isRequestedSessionIdFromCookie();
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return request.isRequestedSessionIdFromCookie();
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return request.isRequestedSessionIdFromURL();
    }

    @SuppressWarnings( "deprecation" )
    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return request.isRequestedSessionIdFromUrl();
    }

}
