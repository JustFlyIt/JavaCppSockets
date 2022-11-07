#include "stdafx.h"
#include "SocketSender.h"

SocketSender::SocketSender(SOCKET client) {
	this->clientSocket = client;
}

void SocketSender::sendHostnameResponse() {
	char hostname[32];
	gethostname(hostname, 32);

	char buffer[512];
	buffer[0] = 0;
	sprintf_s( 
		buffer, 
		"<Response><Name>HostnameResponse</Name><Hostname>%s</Hostname></Response>\n", hostname);

	sendXMLToClient(buffer);
}

void SocketSender::sendMemoryResponse() {
	MEMORYSTATUS memory;
	GlobalMemoryStatus(&memory);

	char buffer[512];
	buffer[0] = 0;
	sprintf_s( 
		buffer, 
		"<Response><Name>MemoryResponse</Name><TotalPhysicalMemory>%i</TotalPhysicalMemory></Response>\n", 
		memory.dwTotalPhys);

	sendXMLToClient(buffer);
}

void SocketSender::sendRandomNumberResponse() {
	char buffer[512];
	buffer[0] = 0;

	srand(GetTickCount());
	int num = rand();

	sprintf_s(buffer, "<Response><Name>RandomNumberResponse</Name><Number>%i</Number></Response>\n", num);
	sendXMLToClient(buffer);
}

void SocketSender::sendXMLToClient(char xml[]) {
	// Send some XML to the client
	int len = strlen(xml);
    int sent = send( clientSocket, xml, len, 0 );

    if ( sent == SOCKET_ERROR ) {
        printf( "send failed\n");
        closesocket( clientSocket );
        return;
    }

	printf( "%i bytes sent to client\n", sent);
}
