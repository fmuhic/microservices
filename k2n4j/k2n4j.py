import json
from kafka import KafkaConsumer
from kafka.errors import KafkaError
from neo4j import GraphDatabase

if __name__ == '__main__':
    consumer = KafkaConsumer(
        'transactions',
        bootstrap_servers=['localhost:9092'],
        group_id="k2n4j_consumers"
    )
    n4j = GraphDatabase.driver("bolt://localhost:7687")

    for msg in consumer:
        try:
            t = json.loads(msg.value)
            n4j.execute_query(
                "MERGE (a:Account { name: $from_name, surename: $from_surename, id: $from_id })-[r:Send { amount: $amount, time: $tr_time }]->(b:Account { name: $to_name, surename: $to_surename, id: $to_id })",
                from_name=t["from"]["firstName"],
                from_surename=t["from"]["lastName"],
                from_id=t["from"]["id"],
                amount=t["amount"],
                tr_time=t["datetime"],
                to_name=t["to"]["firstName"],
                to_surename=t["to"]["lastName"],
                to_id=t["to"]["id"],
            )
        except KafkaError as e:
            print(f'Kafka error occured: ${e}')
        except Exception as e:
            print(f'Unable to process kafka message: ${e}')
