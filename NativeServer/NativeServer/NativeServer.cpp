// NativeServer.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "ServerSocket.h"

#pragma comment(lib, "ws2_32.lib") // link winsock2


int _tmain(int argc, _TCHAR* argv[])
{
	printf("Native server starting\n");

	// Start server socket listener
	ServerSocket* server = new ServerSocket();
	server->startThread();

	// Wait for server socket to terminate
	WaitForSingleObject(server->getThread(), INFINITE);

	return 0;
}

