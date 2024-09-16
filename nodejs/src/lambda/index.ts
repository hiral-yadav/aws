export const handler = async (event: any = {}): Promise<any> => {
    console.log('Received event:', JSON.stringify(event, null, 2));  
    return {
      statusCode: 200,
      body: JSON.stringify({
        message: 'Hello from Lambda!',
        input: event,
      }),
    };
  };
  